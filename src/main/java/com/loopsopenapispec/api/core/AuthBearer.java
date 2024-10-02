package com.loopsopenapispec.api.core;

public class AuthBearer implements AuthProvider {

    private final String token;

    public AuthBearer(String token) {
        this.token = token;
    }

    @Override
    public HttpRequestBuilder addAuth(HttpRequestBuilder builder) {
        builder.addHeader("Authorization", "Bearer " + token);
        return builder;
    }
}
