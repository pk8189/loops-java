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
@JsonDeserialize(builder = TransactionalSuccessResponse.Builder.class)
public final class TransactionalSuccessResponse {
    private final Optional<Boolean> success;

    private TransactionalSuccessResponse(
        Optional<Boolean> success
    ) {
        this.success = success;
    }

    @JsonProperty("success")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getSuccess() {
        return success.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TransactionalSuccessResponse &&
               equalTo((TransactionalSuccessResponse) other);
    }

    private boolean equalTo(TransactionalSuccessResponse other) {
        return
            success.equals(other.success)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.success
               );
    }

    @Override
    public String toString() {
        return "TransactionalSuccessResponse{" +
               "success=" + success +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> success = Optional.empty();

        private Builder() {}

        public Builder from(TransactionalSuccessResponse other) {
            success(other.getSuccess());
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


        public TransactionalSuccessResponse build() {
            return new TransactionalSuccessResponse(
                       success
                   );
        }
    }

}


