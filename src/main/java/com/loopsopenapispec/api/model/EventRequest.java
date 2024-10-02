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
@JsonDeserialize(builder = EventRequest.Builder.class)
public final class EventRequest {
    private final Optional<String> email;
    private final String eventName;
    private final Optional<String> userId;

    private EventRequest(
        Optional<String> email,
        String eventName,
        Optional<String> userId
    ) {
        this.email = email;
        this.eventName = eventName;
        this.userId = userId;
    }

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getEmail() {
        return email.orElse(null);
    }

    @JsonProperty("eventName")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getEventName() {
        return eventName;
    }

    @JsonProperty("userId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUserId() {
        return userId.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof EventRequest && equalTo((EventRequest) other);
    }

    private boolean equalTo(EventRequest other) {
        return
            email.equals(other.email) &&

            eventName.equals(other.eventName) &&

            userId.equals(other.userId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.email,
                   this.eventName,
                   this.userId
               );
    }

    @Override
    public String toString() {
        return "EventRequest{" +
               "email=" + email +
               "eventName=" + eventName +
               "userId=" + userId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> email = Optional.empty();
        private String eventName = null;
        private Optional<String> userId = Optional.empty();

        private Builder() {}

        public Builder from(EventRequest other) {
            email(other.getEmail());
            eventName(other.getEventName());
            userId(other.getUserId());
            return this;
        }

        @JsonSetter("email")
        public Builder email(String email) {
            this.email = Optional.ofNullable(email);
            return this;
        }

        public Builder email(Optional<String> email) {
            this.email = email;
            return this;
        }

        @JsonSetter("eventName")
        public Builder eventName(String eventName) {
            if (eventName == null) {
                throw new IllegalArgumentException("eventName cannot be null");
            }

            this.eventName = eventName;
            return this;
        }


        @JsonSetter("userId")
        public Builder userId(String userId) {
            this.userId = Optional.ofNullable(userId);
            return this;
        }

        public Builder userId(Optional<String> userId) {
            this.userId = userId;
            return this;
        }


        public EventRequest build() {
            if (eventName == null) {
                throw new IllegalStateException("eventName is required");
            }

            return new EventRequest(
                       email,
                       eventName,
                       userId
                   );
        }
    }

}


