package com.loopsopenapispec.api.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpRequestBuilder {

    private final Request.Builder requestBuilder;
    private final OkHttpClient.Builder clientBuilder;
    private final Map<String, String> pathParams;
    private final Map<String, String> queryParams;
    private String baseUrl;
    private String urlPath;
    private Optional<Integer> timeout;
    private TimeUnit timeoutTimeUnit;
    private final ObjectMapper objectMapper;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private HttpMethod method;
    private RequestBody body;

    public enum HttpMethod {
        GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS;

        public static HttpMethod fromString(String method) {
            try {
                return valueOf(method.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unsupported HTTP method: " + method, e);
            }
        }
    }

    public HttpRequestBuilder() {
        this.requestBuilder = new Request.Builder();
        this.clientBuilder = new OkHttpClient.Builder();
        this.pathParams = new HashMap<>();
        this.queryParams = new HashMap<>();
        this.timeout = Optional.empty();
        this.timeoutTimeUnit = TimeUnit.SECONDS;
        this.objectMapper = new ObjectMapper();
    }

    public HttpRequestBuilder baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public HttpRequestBuilder path(String urlPath) {
        this.urlPath = urlPath;
        return this;
    }

    public HttpRequestBuilder addPathParam(String key, String value) {
        this.pathParams.put(key, value);
        return this;
    }

    public HttpRequestBuilder addQueryParam(String key, String value) {
        if (value.startsWith("[") && value.endsWith("]")) {
            // Remove brackets and URL decode
            String decodedValue = URLDecoder.decode(value.substring(1, value.length() - 1),
                                                    StandardCharsets.UTF_8);
            String formattedValue = Arrays.stream(decodedValue.split(","))
                                    .map(String::trim)
                                    .collect(Collectors.joining(","));
            this.queryParams.put(key, formattedValue);
        } else {
            this.queryParams.put(key, value);
        }

        return this;
    }

    public HttpRequestBuilder addQueryParamExploding(String key, String value) {
        if (value.startsWith("[") && value.endsWith("]")) {
            String explodedValue = Arrays.stream(value.substring(1, value.length() - 1).split(","))
                                   .map(String::trim)
                                   .collect(Collectors.joining("&" + key + "=", key + "=", ""));
            this.queryParams.put(key, explodedValue);
        } else {
            // Handle regular parameters
            this.queryParams.put(key, value);
        }

        return this;
    }

    public HttpRequestBuilder addAuth(AuthProvider provider) {

        if (provider != null) {
            return provider.addAuth(this);
        }

        return this;
    }

    public HttpRequestBuilder method(HttpMethod method) {
        this.method = method;
        return this;
    }

    public HttpRequestBuilder method(String method) {
        this.method = HttpMethod.fromString(method);
        return this;
    }

    public HttpRequestBuilder setJsonBody(Object body) throws IOException {
        String jsonBody = objectMapper.writeValueAsString(body);
        this.body = RequestBody.create(jsonBody, JSON);
        return this;
    }

    public HttpRequestBuilder setMultipartBody(Object formData, String mediaTypeString) {
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
        .setType(MultipartBody.FORM);

        addObjectToMultipartBody(multipartBuilder, formData, mediaTypeString);

        this.body = multipartBuilder.build();
        return this;
    }

    private void addObjectToMultipartBody(MultipartBody.Builder multipartBuilder, Object obj,
                                          String mediaTypeString) {
        for (Method declaredMethod : obj.getClass().getDeclaredMethods()) {
            JsonProperty jsonProperty = declaredMethod.getAnnotation(JsonProperty.class);

            if (jsonProperty != null) {
                String fieldName = jsonProperty.value();

                try {
                    Object value = declaredMethod.invoke(obj);
                    addPartToMultipartBody(multipartBuilder, fieldName, value, mediaTypeString);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalArgumentException("Cannot construct form data from type", e);
                }
            }
        }
    }

    private void addPartToMultipartBody(MultipartBody.Builder multipartBuilder, String key,
                                        Object value, String mediaTypeString) {
        if (value == null) {
            return;
        }

        if (value instanceof File) {
            File file = (File) value;
            multipartBuilder.addFormDataPart(key, file.getName(),
                                             RequestBody.create(file, MediaType.parse(mediaTypeString)));
        } else if (value instanceof String) {
            multipartBuilder.addFormDataPart(key, (String) value);
        } else if (value instanceof Collection) {
            for (Object item : (Collection<?>) value) {
                addPartToMultipartBody(multipartBuilder, key, item, mediaTypeString);
            }
        } else {
            multipartBuilder.addFormDataPart(key, String.valueOf(value));
        }
    }

    public HttpRequestBuilder setBinaryBody(File file, String mediaTypeString) throws IOException {
        MediaType mediaType = MediaType.parse(mediaTypeString);
        this.body = RequestBody.create(file, mediaType);
        return this;
    }

    public HttpRequestBuilder setRawBody(String content, String mediaTypeString) {
        MediaType mediaType = MediaType.parse(mediaTypeString);
        this.body = RequestBody.create(content, mediaType);
        return this;
    }

    public HttpRequestBuilder setFormUrlEncodedBody(Object body) throws IOException {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        addObjectToFormBody(formBodyBuilder, body);
        this.body = formBodyBuilder.build();
        return this;
    }

    private void addObjectToFormBody(FormBody.Builder formBodyBuilder, Object obj) {
        for (Method declaredMethod : obj.getClass().getDeclaredMethods()) {
            JsonProperty jsonProperty = declaredMethod.getAnnotation(JsonProperty.class);

            if (jsonProperty != null) {
                String fieldName = jsonProperty.value();

                try {
                    Object value = declaredMethod.invoke(obj);
                    addValueToFormBody(formBodyBuilder, fieldName, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalArgumentException("Cannot construct form data from type", e);
                }
            }
        }
    }

    private void addValueToFormBody(FormBody.Builder formBodyBuilder, String key, Object value) {
        if (value == null) {
            return;
        }

        if (value instanceof String) {
            formBodyBuilder.add(key, (String) value);
        } else if (value instanceof Collection) {
            for (Object item : (Collection<?>) value) {
                addValueToFormBody(formBodyBuilder, key, item);
            }
        } else {
            formBodyBuilder.add(key, ObjectMappers.stringify(value));
        }
    }

    public HttpRequestBuilder addHeader(String name, String value) {
        if (value != null) {
            requestBuilder.addHeader(name, value);
        }

        return this;
    }

    public HttpRequestBuilder timeout(int timeout) {
        this.timeout = Optional.of(timeout);
        return this;
    }

    public HttpRequestBuilder timeout(int timeout, TimeUnit timeoutTimeUnit) {
        this.timeout = Optional.of(timeout);
        this.timeoutTimeUnit = timeoutTimeUnit;
        return this;
    }

    public Response execute() throws IOException {
        if (baseUrl == null || urlPath == null || method == null) {
            throw new IllegalStateException("baseUrl, path, and method must be set before executing the request.");
        }

        String resolvedPath = urlPath;

        for (Map.Entry<String, String> entry : pathParams.entrySet()) {
            resolvedPath = resolvedPath.replace("{" + entry.getKey() + "}", entry.getValue());
        }

        HttpUrl parsedUrl = HttpUrl.parse(baseUrl);

        if (parsedUrl == null) {
            throw new IllegalArgumentException("Invalid base URL: " + baseUrl);
        }

        HttpUrl.Builder urlBuilder = parsedUrl.newBuilder();

        // Add path segments
        String pathToAdd = resolvedPath.startsWith("/") ? resolvedPath.substring(1) : resolvedPath;
        urlBuilder.addPathSegments(pathToAdd);

        // Add query parameters
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value.startsWith(key + "=") && value.contains("&" + key + "=")) {
                // This is an exploded parameter
                String[] explodedValues = value.split("&");

                for (String explodedValue : explodedValues) {
                    String[] keyValue = explodedValue.split("=", 2);

                    if (keyValue.length == 2) {
                        urlBuilder.addQueryParameter(keyValue[0], keyValue[1]);
                    }
                }
            } else {
                // This is a regular parameter
                urlBuilder.addQueryParameter(key, value);
            }
        }

        requestBuilder.url(urlBuilder.build());

        switch (method) {
            case GET:
                requestBuilder.get();
                break;

            case POST:
                requestBuilder.post(body != null ? body : RequestBody.create(new byte[0], null));
                break;

            case PUT:
                requestBuilder.put(body != null ? body : RequestBody.create(new byte[0], null));
                break;

            case DELETE:
                requestBuilder.delete(body);
                break;

            case PATCH:
                requestBuilder.patch(body != null ? body : RequestBody.create(new byte[0], null));
                break;

            case HEAD:
                requestBuilder.head();
                break;

            case OPTIONS:
                requestBuilder.method("OPTIONS", null);
                break;
        }

        if (timeout.isPresent()) {
            clientBuilder.callTimeout(timeout.get(), timeoutTimeUnit);
        }

        OkHttpClient client = clientBuilder.build();
        Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new ApiException("API returned a non successful error code: " + response.code(), response);
        }

        return response;
    }
}
