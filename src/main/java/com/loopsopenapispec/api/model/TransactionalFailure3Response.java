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
@JsonDeserialize(builder = TransactionalFailure3Response.Builder.class)
public final class TransactionalFailure3Response {
    private final Optional<String> message;
    private final Optional<Boolean> success;

    private TransactionalFailure3Response(
        Optional<String> message,
        Optional<Boolean> success
    ) {
        this.message = message;
        this.success = success;
    }

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getMessage() {
        return message.orElse(null);
    }

    @JsonProperty("success")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getSuccess() {
        return success.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TransactionalFailure3Response &&
               equalTo((TransactionalFailure3Response) other);
    }

    private boolean equalTo(TransactionalFailure3Response other) {
        return
            message.equals(other.message) &&

            success.equals(other.success)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.message,
                   this.success
               );
    }

    @Override
    public String toString() {
        return "TransactionalFailure3Response{" +
               "message=" + message +
               "success=" + success +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> message = Optional.empty();
        private Optional<Boolean> success = Optional.empty();

        private Builder() {}

        public Builder from(TransactionalFailure3Response other) {
            message(other.getMessage());
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

        @JsonSetter("success")
        public Builder success(Boolean success) {
            this.success = Optional.ofNullable(success);
            return this;
        }

        public Builder success(Optional<Boolean> success) {
            this.success = success;
            return this;
        }


        public TransactionalFailure3Response build() {
            return new TransactionalFailure3Response(
                       message,
                       success
                   );
        }
    }

}


