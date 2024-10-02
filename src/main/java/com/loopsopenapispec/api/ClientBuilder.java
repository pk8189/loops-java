package com.loopsopenapispec.api;

import com.loopsopenapispec.api.core.AuthBearer;
import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.Environment;

public final class ClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public ClientBuilder withApiKey(String token) {
        this.clientOptionsBuilder.addAuth("apiKey", new AuthBearer(token));
        return this;
    }


    public ClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public ClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public Client build() {
        clientOptionsBuilder.environment(this.environment);
        return new Client(clientOptionsBuilder.build());
    }
}
