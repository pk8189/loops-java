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
@JsonDeserialize(builder = ContactSuccessResponse.Builder.class)
public final class ContactSuccessResponse {
    private final Optional<String> id;
    private final Optional<Boolean> success;

    private ContactSuccessResponse(
        Optional<String> id,
        Optional<Boolean> success
    ) {
        this.id = id;
        this.success = success;
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id.orElse(null);
    }

    @JsonProperty("success")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getSuccess() {
        return success.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ContactSuccessResponse && equalTo((ContactSuccessResponse) other);
    }

    private boolean equalTo(ContactSuccessResponse other) {
        return
            id.equals(other.id) &&

            success.equals(other.success)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.id,
                   this.success
               );
    }

    @Override
    public String toString() {
        return "ContactSuccessResponse{" +
               "id=" + id +
               "success=" + success +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();
        private Optional<Boolean> success = Optional.empty();

        private Builder() {}

        public Builder from(ContactSuccessResponse other) {
            id(other.getId());
            success(other.getSuccess());
            return this;
        }

        @JsonSetter("id")
        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        public Builder id(Optional<String> id) {
            this.id = id;
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


        public ContactSuccessResponse build() {
            return new ContactSuccessResponse(
                       id,
                       success
                   );
        }
    }

}


