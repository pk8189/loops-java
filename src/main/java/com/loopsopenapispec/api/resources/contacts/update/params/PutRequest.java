package com.loopsopenapispec.api.resources.contacts.update.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.loopsopenapispec.api.model.ContactRequest;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PutRequest.Builder.class)
public final class PutRequest {
    private final ContactRequest data;

    private PutRequest(
        ContactRequest data
    ) {
        this.data = data;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ContactRequest getData() {
        return data;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof PutRequest && equalTo((PutRequest) other);
    }

    private boolean equalTo(PutRequest other) {
        return
            data.equals(other.data)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.data
               );
    }

    @Override
    public String toString() {
        return "PutRequest{" +
               "data=" + data +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ContactRequest data = null;

        private Builder() {}

        public Builder from(PutRequest other) {
            data(other.getData());
            return this;
        }

        @JsonSetter("data")
        public Builder data(ContactRequest data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }



        public PutRequest build() {
            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new PutRequest(
                       data
                   );
        }
    }

}




