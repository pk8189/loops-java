package com.loopsopenapispec.api.resources.contacts.create;

import java.io.IOException;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.HttpRequestBuilder;
import com.loopsopenapispec.api.core.RequestOptions;
import com.loopsopenapispec.api.core.ResponseHandler;
import com.loopsopenapispec.api.model.ContactSuccessResponse;
import com.loopsopenapispec.api.resources.contacts.create.params.CreateRequest;
import okhttp3.Response;

public class CreateClient {
    protected final ClientOptions clientOptions;

    public CreateClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Add a contact to your audience.
    */
    public ContactSuccessResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Add a contact to your audience.
    */
    public ContactSuccessResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/contacts/create")
            .method("POST")
            .addAuth(clientOptions.getAuth("apiKey"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, ContactSuccessResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }

}