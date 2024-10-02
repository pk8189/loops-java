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
@JsonDeserialize(builder = TransactionalFailure2ResponseError.Builder.class)
public final class TransactionalFailure2ResponseError {
    private final Optional<String> message;
    private final Optional<String> path;

    private TransactionalFailure2ResponseError(
        Optional<String> message,
        Optional<String> path
    ) {
        this.message = message;
        this.path = path;
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


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TransactionalFailure2ResponseError &&
               equalTo((TransactionalFailure2ResponseError) other);
    }

    private boolean equalTo(TransactionalFailure2ResponseError other) {
        return
            message.equals(other.message) &&

            path.equals(other.path)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.message,
                   this.path
               );
    }

    @Override
    public String toString() {
        return "TransactionalFailure2ResponseError{" +
               "message=" + message +
               "path=" + path +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> message = Optional.empty();
        private Optional<String> path = Optional.empty();

        private Builder() {}

        public Builder from(TransactionalFailure2ResponseError other) {
            message(other.getMessage());
            path(other.getPath());
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


        public TransactionalFailure2ResponseError build() {
            return new TransactionalFailure2ResponseError(
                       message,
                       path
                   );
        }
    }

}


