package com.loopsopenapispec.api;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.model.ContactDeleteRequest;
import com.loopsopenapispec.api.resources.contacts.delete.params.CreateRequest;
import org.junit.jupiter.api.Test;

public final class ContactsDeleteTestClient {
    @Test
    void testCreate200SuccessDefault() {
        Client client = Client
                        .builder()
                        .withApiKey(System.getenv("API_TOKEN"))
                        .url("https://api.sideko-staging.dev/v1/mock/sideko-octa/loops/0.1.0")
                        .build();

        try {
            client.contacts().delete().create(CreateRequest
                                              .builder()
                                              .data(ContactDeleteRequest
                                                    .builder()
                                                    .email("string")
                                                    .userId("string")
                                                    .build())
                                              .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}