package com.loopsopenapispec.api.model;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TransactionalFailureResponse.Builder.class)
public final class TransactionalFailureResponse {
    private final Optional<String> message;
    private final Optional<String> path;
    private final Optional<Boolean> success;

    private TransactionalFailureResponse(
        Optional<String> message,
        Optional<String> path,
        Optional<Boolean> success
    ) {
        this.message = message;
        this.path = path;
        this.success = success;
    }

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getMessage() {
        return message.orElse(null);
    }

    @JsonProperty("path")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getPath() {
        return path.orElse(null);
    }

    @JsonProperty("success")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getSuccess() {
        return success.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TransactionalFailureResponse &&
               equalTo((TransactionalFailureResponse) other);
    }

    private boolean equalTo(TransactionalFailureResponse other) {
        return
            message.equals(other.message) &&

            path.equals(other.path) &&

            success.equals(other.success)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.message,
                   this.path,
                   this.success
               );
    }

    @Override
    public String toString() {
        return "TransactionalFailureResponse{" +
               "message=" + message +
               "path=" + path +
               "success=" + success +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> message = Optional.empty();
        private Optional<String> path = Optional.empty();
        private Optional<Boolean> success = Optional.empty();

        private Builder() {}

        public Builder from(TransactionalFailureResponse other) {
            message(other.getMessage());
            path(other.getPath());
            success(other.getSuccess());
            return this;
        }

        @JsonSetter("message")
        public Builder message(String message) {
            this.message = Optional.ofNullable(message);
            return this;
        }

        public Builder message(Optional<String> message) {
            this.message = message;
            return this;
        }

        @JsonSetter("path")
        public Builder path(String path) {
            this.path = Optional.ofNullable(path);
            return this;
        }

        public Builder path(Optional<String> path) {
            this.path = path;
            return this;
        }

        @JsonSetter("success")
        public Builder success(Boolean success) {
            this.success = Optional.ofNullable(success);
            return this;
        }

        public Builder success(Optional<Boolean> success) {
            this.success = success;
            return this;
        }


        public TransactionalFailureResponse build() {
            return new TransactionalFailureResponse(
                       message,
                       path,
                       success
                   );
        }
    }

}


