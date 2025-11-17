package pl.wtx.vies;

import pl.wtx.vies.api.client.config.GsonConfig;
import pl.wtx.vies.api.client.config.OkHttpClientConfig;
import pl.wtx.vies.api.client.invoker.ApiClient;
import pl.wtx.vies.api.client.invoker.JSON;

/**
 * The VIES (VAT Information Exchange System) API Client
 * @author WTX Labs
 * @see https://github.com/wtx-labs/vies-api-client-java
 * @license MIT
 */
public class ViesApiClient extends ApiClient {

    // Default setup of the API Client to provide ignoring not recognized fields in the response.
    public ViesApiClient() {
        JSON.setGson(GsonConfig.createGson());
        setUserAgent("ViesApiClient (by wtx-labs)");
    }

    // Default configuration improved with logging API communication messages.
    public ViesApiClient(boolean enableLoggingApiMessages) {

        JSON.setGson(GsonConfig.createGson());
        setUserAgent("ViesApiClient (by wtx-labs)");

        if (enableLoggingApiMessages) {
            setHttpClient(OkHttpClientConfig.configureClient(getHttpClient()));
        }

    }

}
