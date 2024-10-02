package com.loopsopenapispec.api;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.resources.contacts.find.params.ListRequest;
import org.junit.jupiter.api.Test;

public final class ContactsFindTestClient {
    @Test
    void testList200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withApiKey(System.getenv("API_TOKEN"))
                        .url("https://api.sideko-staging.dev/v1/mock/sideko-octa/loops/0.1.0")
                        .build();

        try {
            client.contacts().find().list(ListRequest
                                          .builder()
                                          .email("string")
                                          .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}