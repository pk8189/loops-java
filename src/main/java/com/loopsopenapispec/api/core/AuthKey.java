package com.loopsopenapispec.api.core;

public class AuthKey implements AuthProvider {

    private final AuthKeyLocation location;
    private final String name;
    private final String key;

    public AuthKey(AuthKeyLocation location, String name, String key) {
        this.location = location;
        this.name = name;
        this.key = key;
    }

    @Override
    public HttpRequestBuilder addAuth(HttpRequestBuilder builder) {
        switch (this.location) {
            case HEADER_KEY:
                return builder.addHeader(this.name, this.key);

            case QUERY_KEY:
                return builder.addQueryParam(this.name, this.key);

            case COOKIE_KEY:
                return builder.addHeader("Cookie", this.name + "=" + this.key);

            default:
                throw new UnsupportedOperationException("Unable to add auth for key location " + this.location);
        }
    }
}
