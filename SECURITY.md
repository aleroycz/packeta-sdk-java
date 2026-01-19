# Security Policy

## Supported Versions

We provide security updates only for the most recent minor versions of the currently active major releases.  
Older versions receive critical security fixes only in very exceptional cases (e.g. severe RCE actively exploited in the wild).

| Version    | Supported                          | Receiving Security Updates       | Notes                             |
|------------|------------------------------------|----------------------------------|-----------------------------------|
|  1.0.0     | :white_check_mark: Yes             | Full (critical + high)           | Current stable release            |

**Latest release:** Check the [Releases page](https://github.com/aleroycz/packeta-sdk-java/releases)

We generally aim to support the latest two minor versions of the current major release.  
When a new major version is released, the oldest major version usually goes end-of-life.

## Reporting a Vulnerability

**We take security seriously.**  
If you believe you have discovered a security vulnerability in our project, please **report it privately** so we can fix it before it becomes public knowledge.

### Preferred way — Private Vulnerability Reporting (recommended)

We strongly recommend using GitHub's built-in **Private vulnerability reporting** feature:  
→ [Report a Vulnerability](https://github.com/aleroycz/packeta-sdk-java/security/advisories/new)

This is the fastest and most secure way — the report goes directly to the maintainers privately.

### Alternative ways

If for any reason you cannot use the GitHub form, please send an email to:

**podmaster@cipron.cz**  
(Replace with your real security contact email or podmaster@cipron.cz)

Please use our **PGP key** for sensitive information:  
Fingerprint: `1340 E271 0E61 7AB3 F5BE  8611 702B 939A 9834 C334`  
Key ID: `0x702B939A9834C334`

**Please do NOT report security vulnerabilities via public issues, discussions, Twitter/X, Discord, etc.**

### What to expect after reporting
- You should receive an acknowledgment within **48 hours** (usually much faster).
- We will follow up with status updates at least every **7 days** (or sooner if there is important progress).
- Typical timeline after a valid report:
  - Initial triage: 1–3 days
  - Fix development & testing: 1–30 days (depends on severity/complexity)
  - Coordinated release: we prefer to coordinate public disclosure with a fixed release date
- If the report is declined (not a vulnerability / out of scope), we will explain why.
- We are happy to credit responsible reporters in the release notes / Hall of Fame (unless you prefer to stay anonymous).

Thank you for helping keep our project and its users safe!  
Responsible disclosure is greatly appreciated. ❤️
