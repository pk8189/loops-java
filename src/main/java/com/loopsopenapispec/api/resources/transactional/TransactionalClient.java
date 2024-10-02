package com.loopsopenapispec.api.resources.transactional;

import java.io.IOException;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.HttpRequestBuilder;
import com.loopsopenapispec.api.core.RequestOptions;
import com.loopsopenapispec.api.core.ResponseHandler;
import com.loopsopenapispec.api.model.TransactionalSuccessResponse;
import com.loopsopenapispec.api.resources.transactional.params.CreateRequest;
import okhttp3.Response;

public class TransactionalClient {
    protected final ClientOptions clientOptions;

    public TransactionalClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Send a transactional email to a contact.
    */
    public TransactionalSuccessResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Send a transactional email to a contact.
    */
    public TransactionalSuccessResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/transactional")
            .method("POST")
            .addAuth(clientOptions.getAuth("apiKey"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, TransactionalSuccessResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }

}