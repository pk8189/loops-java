package com.loopsopenapispec.api;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.model.ContactRequest;
import com.loopsopenapispec.api.resources.contacts.update.params.PutRequest;
import org.junit.jupiter.api.Test;

public final class ContactsUpdateTestClient {
    @Test
    void testPut200SuccessDefault() {
        Client client = Client
                        .builder()
                        .withApiKey(System.getenv("API_TOKEN"))
                        .url("https://api.sideko-staging.dev/v1/mock/sideko-octa/loops/0.1.0")
                        .build();

        try {
            client.contacts().update().put(PutRequest
                                           .builder()
                                           .data(ContactRequest
                                                 .builder()
                                                 .email("string")
                                                 .firstName("string")
                                                 .lastName("string")
                                                 .subscribed(true)
                                                 .userGroup("string")
                                                 .userId("string")
                                                 .build())
                                           .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}