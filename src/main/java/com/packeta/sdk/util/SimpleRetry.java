package com.packeta.sdk.util;

import com.packeta.sdk.exception.ExternalGatewayFaultException;
import com.packeta.sdk.exception.PacketaApiException;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Utility for retrying operations that may fail transiently (e.g. network / external gateway issues).
 *
 * <p>Designed to work with lambdas that may throw {@link RuntimeException} (checked exceptions
 * should be wrapped by the caller into RuntimeException or a subclass).</p>
 */
@UtilityClass
public class SimpleRetry {
    private static final Logger log = LoggerFactory.getLogger(SimpleRetry.class);
    private static final Random JITTER = new Random();

    /**
     * Executes the given operation with automatic retries on retryable failures.
     *
     * @param operation      The operation to execute (may throw RuntimeException)
     * @param maxRetries     Maximum number of retry attempts (excluding the first try)
     * @param baseBackoffMs  Base delay in milliseconds for exponential backoff
     * @param <T>            Return type of the operation
     * @return Result of the successful operation
     * @throws RuntimeException the last exception thrown (after retries exhausted)
     */
    public static <T> T withRetry(
            Supplier<T> operation,
            int maxRetries,
            long baseBackoffMs) {

        RuntimeException lastException = null;

        for (int attempt = 0; attempt <= maxRetries; attempt++) {
            try {
                return operation.get();
            } catch (RuntimeException e) {
                lastException = e;

                boolean isRetryable = isRetryable(e);

                if (!isRetryable || attempt == maxRetries) {
                    throw e;
                }

                log.warn("Retry attempt {}/{} failed: {}", attempt + 1, maxRetries + 1, e.getMessage());

                sleepWithBackoff(baseBackoffMs, attempt);
            }
        }

        throw lastException != null
                ? lastException
                : new RuntimeException("Retry loop terminated unexpectedly");
    }

    /**
     * Decides whether the given exception should trigger a retry.
     */
    private static boolean isRetryable(RuntimeException rte) {
        Throwable cause = rte.getCause();

        if (cause instanceof ExternalGatewayFaultException) {
            return true;
        }

        if (cause instanceof PacketaApiException pae) {
            return pae.isRetryable();
        }

        return cause instanceof java.net.SocketTimeoutException ||
                cause instanceof java.net.ConnectException;
    }

    /**
     * Sleep with exponential backoff + small random jitter to prevent thundering herd.
     *
     * @param baseMillis base delay
     * @param attempt    current attempt number (0-based)
     */
    private static void sleepWithBackoff(long baseMillis, int attempt) {
        long delay = baseMillis * (1L << attempt);

        // Add jitter: ±25% randomness
        long jitter = (long) (delay * 0.25 * (JITTER.nextDouble() - 0.5));
        long actualDelay = Math.max(0, delay + jitter);

        try {
            Thread.sleep(actualDelay);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Retry sleep interrupted", ie);
        }
    }
}