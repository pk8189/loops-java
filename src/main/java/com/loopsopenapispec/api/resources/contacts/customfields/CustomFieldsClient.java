package com.loopsopenapispec.api.resources.contacts.customfields;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.loopsopenapispec.api.core.ApiException;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.HttpRequestBuilder;
import com.loopsopenapispec.api.core.RequestOptions;
import com.loopsopenapispec.api.core.ResponseHandler;
import com.loopsopenapispec.api.model.CustomField;
import okhttp3.Response;

public class CustomFieldsClient {
    protected final ClientOptions clientOptions;

    public CustomFieldsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Retrieve a list of your account's custom contact properties.
    */
    public List<CustomField> list() {
        return list(null);
    }



    /**
    * Retrieve a list of your account's custom contact properties.
    */
    public List<CustomField> list(RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/contacts/customFields")
            .method("GET")
            .addAuth(clientOptions.getAuth("apiKey"))
            .execute();
            return ResponseHandler.processJsonResponse(response, new TypeReference<List<CustomField>>() {});
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }

}