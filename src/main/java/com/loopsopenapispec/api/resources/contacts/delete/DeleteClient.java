package com.loopsopenapispec.api.resources.contacts.delete;

import java.io.IOException;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.HttpRequestBuilder;
import com.loopsopenapispec.api.core.RequestOptions;
import com.loopsopenapispec.api.core.ResponseHandler;
import com.loopsopenapispec.api.model.ContactDeleteResponse;
import com.loopsopenapispec.api.resources.contacts.delete.params.CreateRequest;
import okhttp3.Response;

public class DeleteClient {
    protected final ClientOptions clientOptions;

    public DeleteClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Delete a contact by `email` or `userId`.
    */
    public ContactDeleteResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Delete a contact by `email` or `userId`.
    */
    public ContactDeleteResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/contacts/delete")
            .method("POST")
            .addAuth(clientOptions.getAuth("apiKey"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, ContactDeleteResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }

}