package com.loopsopenapispec.api.resources.contacts.find.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListRequest.Builder.class)
public final class ListRequest {
    private final String email;

    private ListRequest(
        String email
    ) {
        this.email = email;
    }

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getEmail() {
        return email;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ListRequest && equalTo((ListRequest) other);
    }

    private boolean equalTo(ListRequest other) {
        return
            email.equals(other.email)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.email
               );
    }

    @Override
    public String toString() {
        return "ListRequest{" +
               "email=" + email +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String email = null;

        private Builder() {}

        public Builder from(ListRequest other) {
            email(other.getEmail());
            return this;
        }

        @JsonSetter("email")
        public Builder email(String email) {
            if (email == null) {
                throw new IllegalArgumentException("email cannot be null");
            }

            this.email = email;
            return this;
        }



        public ListRequest build() {
            if (email == null) {
                throw new IllegalStateException("email is required");
            }

            return new ListRequest(
                       email
                   );
        }
    }

}




