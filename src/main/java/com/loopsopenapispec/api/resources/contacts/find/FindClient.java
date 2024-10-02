package com.loopsopenapispec.api.resources.contacts.find;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.HttpRequestBuilder;
import com.loopsopenapispec.api.core.RequestOptions;
import com.loopsopenapispec.api.core.ResponseHandler;
import com.loopsopenapispec.api.model.Contact;
import com.loopsopenapispec.api.resources.contacts.find.params.ListRequest;
import okhttp3.Response;

public class FindClient {
    protected final ClientOptions clientOptions;

    public FindClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Search for a contact by `email`.
    */
    public List<Contact> list(ListRequest request) {
        return list(request, null);
    }



    /**
    * Search for a contact by `email`.
    */
    public List<Contact> list(ListRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/contacts/find")
            .addQueryParam("email", request.getEmail())
            .method("GET")
            .addAuth(clientOptions.getAuth("apiKey"))
            .execute();
            return ResponseHandler.processJsonResponse(response, new TypeReference<List<Contact>>() {});
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }

}