<div align="center">
  <img src="https://www.packeta.com/img/logo-packeta.svg" alt="Packeta Logo" width="320"/>

  <h1>Packeta Java SDK</h1>

  <p>
    <strong>Modern, type-safe, modular Java client</strong> for the Packeta (Zásilkovna) REST/XML API
  </p>

  <p>
    <strong>⚠️ IMPORTANT NOTICE:</strong><br/>
    This is an <strong>UNOFFICIAL</strong> community/open-source project.<br/>
    It is <strong>not</strong> affiliated with, endorsed by, or supported by Packeta International s.r.o.
  </p>

  <p>
    <a href="https://github.com/aleroycz/packeta-sdk-java/actions/workflows/quality.yml">
      <img src="https://img.shields.io/github/actions/workflow/status/aleroycz/packeta-sdk-java/quality.yml?branch=main&label=Build&logo=github" alt="Build Status"/>
    </a>
    <a href="https://github.com/aleroycz/packeta-sdk-java/releases">
      <img src="https://img.shields.io/github/v/release/aleroycz/packeta-sdk-java?logo=github&color=green" alt="Latest Release"/>
    </a>
    <a href="https://codecov.io/gh/aleroycz/packeta-sdk-java">
      <img src="https://img.shields.io/codecov/c/github/aleroycz/packeta-sdk-java?logo=codecov" alt="Code Coverage"/>
    </a>
    <a href="LICENSE">
      <img src="https://img.shields.io/github/license/yourusername/packeta-sdk-java?color=blue" alt="License: MIT"/>
    </a>
    <a href="https://securityscorecards.dev/viewer/?uri=github.com/aleroycz/packeta-sdk-java">
      <img src="https://api.securityscorecards.dev/projects/github.com/aleroycz/packeta-sdk-java/badge" alt="OpenSSF Scorecard"/>
    </a>
    <a href="https://github.com/aleroycz/packeta-sdk-java/graphs/contributors">
      <img src="https://img.shields.io/github/contributors/aleroycz/packeta-sdk-java" alt="Contributors"/>
    </a>
  </p>

  <p>
    <img src="https://img.shields.io/github/stars/aleroycz/packeta-sdk-java?style=social" alt="Stars"/>
    <img src="https://img.shields.io/github/forks/aleroycz/packeta-sdk-java?style=social" alt="Forks"/>
    <img src="https://img.shields.io/github/watchers/aleroycz/packeta-sdk-java?style=social" alt="Watchers"/>
  </p>

  <img src="https://github-readme-stats.vercel.app/api?username=aleroycz&show_icons=true&theme=dracula&hide_title=true" alt="GitHub Stats"/>

  <img src="https://github-readme-stats.vercel.app/api/top-langs/?username=aleroycz&layout=compact&theme=dracula&hide_title=true" alt="Top Languages"/>
</div>

## Features

- Full support for Packeta REST/XML API
- Modular architecture (core + separate modules for labels, tracking, customs, ...)
- Built-in rate limiting, retries & resilient HTTP client
- Advanced label generation including **vertical return attachments**
- Optional Spring Boot 3.x auto-configuration
- Comprehensive unit & integration tests
- Modern Java (17+), records, sealed interfaces, etc.
- SLSA provenance, SBOM generation, OpenSSF Scorecard

## Installation

### Maven (recommended)

```xml
<dependency>
    <groupId>com.github.aleroycz</groupId>
    <artifactId>packeta-sdk-java</artifactId>
    <version>1.0.0-unofficial</version> <!-- use latest version -->
</dependency>
```