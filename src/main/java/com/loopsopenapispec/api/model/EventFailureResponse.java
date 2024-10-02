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
@JsonDeserialize(builder = EventFailureResponse.Builder.class)
public final class EventFailureResponse {
    private final Optional<String> message;
    private final Optional<Boolean> success;

    private EventFailureResponse(
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

        return other instanceof EventFailureResponse && equalTo((EventFailureResponse) other);
    }

    private boolean equalTo(EventFailureResponse other) {
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
        return "EventFailureResponse{" +
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

        public Builder from(EventFailureResponse other) {
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


        public EventFailureResponse build() {
            return new EventFailureResponse(
                       message,
                       success
                   );
        }
    }

}


