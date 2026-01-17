package com.packeta.sdk.util;

import com.google.common.util.concurrent.RateLimiter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Rate limiter using Guava's RateLimiter.
 * Helps prevent hitting Packeta's undocumented rate limits.
 */
@RequiredArgsConstructor
@Getter
public class RateLimit {

    private final RateLimiter rateLimiter;

    /**
     * Creates a rate limiter with the specified permits per second.
     *
     * @param permitsPerSecond e.g., 10.0 for 10 requests/second
     * @return configured RateLimiter
     */
    public static RateLimit create(double permitsPerSecond) {
        return new RateLimit(RateLimit.create(permitsPerSecond).getRateLimiter());
    }

    /**
     * Acquires a permit (blocks if rate limit exceeded).
     */
    public void acquire() {
        rateLimiter.acquire();
    }

    /**
     * Tries to acquire a permit without blocking.
     *
     * @return true if acquired immediately
     */
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }

    /**
     * Default conservative limiter for Packeta API (10 req/s).
     * Adjust based on your account's actual limits.
     */
    public static RateLimiter defaultPacketaLimiter() {
        return create(10.0).getRateLimiter();
    }
}