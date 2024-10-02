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
@JsonDeserialize(builder = TransactionalFailure2Response.Builder.class)
public final class TransactionalFailure2Response {
    private final Optional<TransactionalFailure2ResponseError> error;
    private final Optional<Boolean> success;

    private TransactionalFailure2Response(
        Optional<TransactionalFailure2ResponseError> error,
        Optional<Boolean> success
    ) {
        this.error = error;
        this.success = success;
    }

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public TransactionalFailure2ResponseError getError() {
        return error.orElse(null);
    }

    @JsonProperty("success")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getSuccess() {
        return success.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TransactionalFailure2Response &&
               equalTo((TransactionalFailure2Response) other);
    }

    private boolean equalTo(TransactionalFailure2Response other) {
        return
            error.equals(other.error) &&

            success.equals(other.success)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.error,
                   this.success
               );
    }

    @Override
    public String toString() {
        return "TransactionalFailure2Response{" +
               "error=" + error +
               "success=" + success +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<TransactionalFailure2ResponseError> error = Optional.empty();
        private Optional<Boolean> success = Optional.empty();

        private Builder() {}

        public Builder from(TransactionalFailure2Response other) {
            error(other.getError());
            success(other.getSuccess());
            return this;
        }

        @JsonSetter("error")
        public Builder error(TransactionalFailure2ResponseError error) {
            this.error = Optional.ofNullable(error);
            return this;
        }

        public Builder error(Optional<TransactionalFailure2ResponseError> error) {
            this.error = error;
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


        public TransactionalFailure2Response build() {
            return new TransactionalFailure2Response(
                       error,
                       success
                   );
        }
    }

}


