# VIES API Client for Java

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-8%2B-blue)](https://www.java.com)
[![Maven Central](https://img.shields.io/maven-central/v/pl.wtx.vies/vies-api-client?label=Maven%20Central&logo=apache-maven&color=blue)](https://mvnrepository.com/artifact/pl.wtx.vies/vies-api-client)

A lightweight Java client for the public [VIES REST API](https://ec.europa.eu/taxation_customs/vies/) that validates EU VAT numbers and reports the availability of national VAT systems. 🚀

This client gives you type-safe access to the official VIES endpoints so you can:
- Check VAT numbers for any EU member state
- Exercise the built‑in VIES test service
- Monitor the status of individual tax administrations

## ✨ Why choose this client?

- 💡 **Type-safe Java API** – generated models and operations for each VIES REST endpoint
- ⚙️ **Zero-auth configuration** – VIES is a public API, so no credentials are required
- 📦 **OkHttp + Gson stack** – customizable HTTP client with optional logging
- ⚡ **Compatible with API specification** - based on official [API specification](https://ec.europa.eu/assets/taxud/vow-information/swagger_publicVAT.yaml)

## 🎯 Currently implemented features

- ✅ `checkVatNumber`
  - Validate a VAT number in a selected member state
  - Retrieve trader name/address and optional match indicators
- ✅ `checkVatTestService`
  - Hit the official VIES sandbox without touching production data
  - Exercise request payloads used in certification
- ✅ `checkStatus`
  - List availability per member state
  - Inspect VIES-wide operational status

## 🚨 Project status

> ⚠️ **Note:** This is the first public release focused on VIES REST endpoints.  
> Feedback and contributions are very welcome!

## 📦 Version information

- **Current version**: `1.0.0`
- **Supported API**: VIES REST (`/rest-api`)
- **Java compatibility**: 8+

## 🔓 License

**MIT License**

Use, modify, and distribute freely while keeping the original attribution.

## 🚀 Quick start guide

### 1️⃣ Installation

Clone and build from source:

```bash
git clone https://github.com/wtx-labs/vies-api-client-java.git
cd vies-api-client-java
mvn clean install
```

Add the artifact to your project:

```xml
<dependency>
    <groupId>pl.wtx.vies</groupId>
    <artifactId>vies-api-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2️⃣ Java integration example

```java
package pl.wtx.vies;

import pl.wtx.vies.api.client.PublicApi;
import pl.wtx.vies.api.client.invoker.ApiException;
import pl.wtx.vies.api.client.model.CheckVatRequest;
import pl.wtx.vies.api.client.model.CheckVatResponse;

/**
 * The VIES (VAT Information Exchange System) API Client - Usage Demo
 * @author WTX Labs
 * @see https://github.com/wtx-labs/vies-api-client-java
 * @license MIT
 */
public class ViesApiClientUsageDemo {

    private static final String BASE_PATH = "https://ec.europa.eu/taxation_customs/vies/rest-api";

    public static void main(String[] args) {

        System.out.println(">>> Start running the ViesApiClientUsageDemo...");

        ViesApiClient apiClient = new ViesApiClient();
        apiClient.setBasePath(BASE_PATH);

        PublicApi publicApi = new PublicApi(apiClient);

        try {

            CheckVatRequest checkVatRequest = new CheckVatRequest();
            checkVatRequest.setCountryCode("PL");
            checkVatRequest.setVatNumber("1234567890");

            CheckVatResponse checkVatResponse = publicApi.checkVatNumber(checkVatRequest);

            System.out.println("Is VIES number valid: " + checkVatResponse.getValid());
            System.out.println("Name: " + checkVatResponse.getName());
            System.out.println("Address: " + checkVatResponse.getAddress());

        } catch (ApiException e) {
            System.err.println("API Error: " + e.getMessage());
        }

        System.out.println("<<< The <<< ViesApiClientUsageDemo has been finished.");

    }

}
```

## 🔗 Get involved

- ✨ Track issues: https://github.com/wtx-labs/vies-api-client-java/issues
- 💡 Have ideas? Open an issue or PR – community contributions are welcome!
- 🌟 Star the repo if this saves you time

## 📊 Project statistics

- 🚀 Fresh VIES-focused client
- 🔄 Continuous improvements driven by OpenAPI updates
- 👥 Maintained by WTX Labs

## 🔍 Keywords

vies java client, eu vat validation java, vies rest api java, vat information exchange system java, vat number check java, vies api client library, vies sdk java

🚀 Happy coding! 😊  
**Your WTX Labs Team** 🚀
