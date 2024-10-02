package com.loopsopenapispec.api.core;

import java.util.Base64;

public class AuthBasic implements AuthProvider {

    private final String username;
    private final String password;

    public AuthBasic(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public HttpRequestBuilder addAuth(HttpRequestBuilder builder) {
        String encodedAuth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        builder.addHeader("Authorization", "Basic " + encodedAuth);
        return builder;
    }
}
