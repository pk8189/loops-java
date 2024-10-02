package com.loopsopenapispec.api.resources.events.send;

import java.io.IOException;

import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.HttpRequestBuilder;
import com.loopsopenapispec.api.core.RequestOptions;
import com.loopsopenapispec.api.core.ResponseHandler;
import com.loopsopenapispec.api.model.EventSuccessResponse;
import com.loopsopenapispec.api.resources.events.send.params.CreateRequest;
import okhttp3.Response;

public class SendClient {
    protected final ClientOptions clientOptions;

    public SendClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Send events to trigger emails in Loops.<br>If a contact with the provided `email` doesn't exist, one will be created.
    */
    public EventSuccessResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Send events to trigger emails in Loops.<br>If a contact with the provided `email` doesn't exist, one will be created.
    */
    public EventSuccessResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/events/send")
            .method("POST")
            .addAuth(clientOptions.getAuth("apiKey"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, EventSuccessResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }

}