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
@JsonDeserialize(builder = ContactDeleteRequest.Builder.class)
public final class ContactDeleteRequest {
    private final Optional<String> email;
    private final Optional<String> userId;

    private ContactDeleteRequest(
        Optional<String> email,
        Optional<String> userId
    ) {
        this.email = email;
        this.userId = userId;
    }

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getEmail() {
        return email.orElse(null);
    }

    @JsonProperty("userId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUserId() {
        return userId.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ContactDeleteRequest && equalTo((ContactDeleteRequest) other);
    }

    private boolean equalTo(ContactDeleteRequest other) {
        return
            email.equals(other.email) &&

            userId.equals(other.userId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.email,
                   this.userId
               );
    }

    @Override
    public String toString() {
        return "ContactDeleteRequest{" +
               "email=" + email +
               "userId=" + userId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> email = Optional.empty();
        private Optional<String> userId = Optional.empty();

        private Builder() {}

        public Builder from(ContactDeleteRequest other) {
            email(other.getEmail());
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

        @JsonSetter("userId")
        public Builder userId(String userId) {
            this.userId = Optional.ofNullable(userId);
            return this;
        }

        public Builder userId(Optional<String> userId) {
            this.userId = userId;
            return this;
        }


        public ContactDeleteRequest build() {
            return new ContactDeleteRequest(
                       email,
                       userId
                   );
        }
    }

}


