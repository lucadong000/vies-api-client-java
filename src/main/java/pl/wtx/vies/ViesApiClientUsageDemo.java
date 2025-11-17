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