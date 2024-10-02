
package com.loopsopenapispec.api.core;

public final class Environment {
    private final String url;
    public static final Environment DEFAULT = new Environment("https://app.loops.so/api/v1");
    public static final Environment MOCK_SERVER = new
    Environment("https://api.sideko-staging.dev/v1/mock/sideko-octa/loops/0.1.0");

    private Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public static Environment custom(String url) {
        return new Environment(url);
    }
}
