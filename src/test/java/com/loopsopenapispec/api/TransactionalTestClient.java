package com.loopsopenapispec.api;

import java.util.Map;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.model.TransactionalRequest;
import com.loopsopenapispec.api.resources.transactional.params.CreateRequest;
import org.junit.jupiter.api.Test;

public final class TransactionalTestClient {
    @Test
    void testCreate200SuccessDefault() {
        Client client = Client
                        .builder()
                        .withApiKey(System.getenv("API_TOKEN"))
                        .url("https://api.sideko-staging.dev/v1/mock/sideko-octa/loops/0.1.0")
                        .build();

        try {
            client.transactional().create(CreateRequest
                                          .builder()
                                          .data(TransactionalRequest
                                                .builder()
                                                .dataVariables(Map.ofEntries(

                                                        ))
                                                .email("string")
                                                .transactionalId("string")
                                                .build())
                                          .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}