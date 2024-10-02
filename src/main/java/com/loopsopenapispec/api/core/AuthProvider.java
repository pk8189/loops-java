package com.loopsopenapispec.api.core;

public interface AuthProvider {

    public HttpRequestBuilder addAuth(HttpRequestBuilder builder);

}
