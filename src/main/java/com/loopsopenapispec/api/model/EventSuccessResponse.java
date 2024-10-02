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
@JsonDeserialize(builder = EventSuccessResponse.Builder.class)
public final class EventSuccessResponse {
    private final Optional<Boolean> success;

    private EventSuccessResponse(
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

        return other instanceof EventSuccessResponse && equalTo((EventSuccessResponse) other);
    }

    private boolean equalTo(EventSuccessResponse other) {
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
        return "EventSuccessResponse{" +
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

        public Builder from(EventSuccessResponse other) {
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


        public EventSuccessResponse build() {
            return new EventSuccessResponse(
                       success
                   );
        }
    }

}


