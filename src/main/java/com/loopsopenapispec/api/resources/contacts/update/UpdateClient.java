package com.loopsopenapispec.api.resources.contacts.update;

import java.io.IOException;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.HttpRequestBuilder;
import com.loopsopenapispec.api.core.RequestOptions;
import com.loopsopenapispec.api.core.ResponseHandler;
import com.loopsopenapispec.api.model.ContactSuccessResponse;
import com.loopsopenapispec.api.resources.contacts.update.params.PutRequest;
import okhttp3.Response;

public class UpdateClient {
    protected final ClientOptions clientOptions;

    public UpdateClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Update a contact by `email` or `userId`.<br>If you want to update a contact’s email address, the contact will first need a `userId` value. You can then make a request containing the userId field along with an updated email address.
    */
    public ContactSuccessResponse put(PutRequest request) {
        return put(request, null);
    }



    /**
    * Update a contact by `email` or `userId`.<br>If you want to update a contact’s email address, the contact will first need a `userId` value. You can then make a request containing the userId field along with an updated email address.
    */
    public ContactSuccessResponse put(PutRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/contacts/update")
            .method("PUT")
            .addAuth(clientOptions.getAuth("apiKey"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, ContactSuccessResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }

}