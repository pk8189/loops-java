package com.loopsopenapispec.api.model;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TransactionalRequest.Builder.class)
public final class TransactionalRequest {
    /**
     * An object containing contact data as defined by the data variables added to the transactional email template.
     */
    private final Optional<Map<?, ?>> dataVariables;
    private final String email;
    /**
     * The ID of the transactional email to send.
     */
    private final String transactionalId;

    private TransactionalRequest(
        Optional<Map<?, ?>> dataVariables,
        String email,
        String transactionalId
    ) {
        this.dataVariables = dataVariables;
        this.email = email;
        this.transactionalId = transactionalId;
    }

    @JsonProperty("dataVariables")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Map<?, ?> getDataVariables() {
        return dataVariables.orElse(null);
    }

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getEmail() {
        return email;
    }

    @JsonProperty("transactionalId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTransactionalId() {
        return transactionalId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TransactionalRequest && equalTo((TransactionalRequest) other);
    }

    private boolean equalTo(TransactionalRequest other) {
        return
            dataVariables.equals(other.dataVariables) &&

            email.equals(other.email) &&

            transactionalId.equals(other.transactionalId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.dataVariables,
                   this.email,
                   this.transactionalId
               );
    }

    @Override
    public String toString() {
        return "TransactionalRequest{" +
               "dataVariables=" + dataVariables +
               "email=" + email +
               "transactionalId=" + transactionalId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Map<?, ?>> dataVariables = Optional.empty();
        private String email = null;
        private String transactionalId = null;

        private Builder() {}

        public Builder from(TransactionalRequest other) {
            dataVariables(other.getDataVariables());
            email(other.getEmail());
            transactionalId(other.getTransactionalId());
            return this;
        }

        @JsonSetter("dataVariables")
        public Builder dataVariables(Map<?, ?> dataVariables) {
            this.dataVariables = Optional.ofNullable(dataVariables);
            return this;
        }

        public Builder dataVariables(Optional<Map<?, ?>> dataVariables) {
            this.dataVariables = dataVariables;
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


        @JsonSetter("transactionalId")
        public Builder transactionalId(String transactionalId) {
            if (transactionalId == null) {
                throw new IllegalArgumentException("transactionalId cannot be null");
            }

            this.transactionalId = transactionalId;
            return this;
        }



        public TransactionalRequest build() {
            if (email == null) {
                throw new IllegalStateException("email is required");
            }

            if (transactionalId == null) {
                throw new IllegalStateException("transactionalId is required");
            }

            return new TransactionalRequest(
                       dataVariables,
                       email,
                       transactionalId
                   );
        }
    }

}


