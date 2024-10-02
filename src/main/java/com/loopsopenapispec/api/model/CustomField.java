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
@JsonDeserialize(builder = CustomField.Builder.class)
public final class CustomField {
    private final Optional<String> key;
    private final Optional<String> label;

    private CustomField(
        Optional<String> key,
        Optional<String> label
    ) {
        this.key = key;
        this.label = label;
    }

    @JsonProperty("key")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getKey() {
        return key.orElse(null);
    }

    @JsonProperty("label")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getLabel() {
        return label.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CustomField && equalTo((CustomField) other);
    }

    private boolean equalTo(CustomField other) {
        return
            key.equals(other.key) &&

            label.equals(other.label)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.key,
                   this.label
               );
    }

    @Override
    public String toString() {
        return "CustomField{" +
               "key=" + key +
               "label=" + label +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> key = Optional.empty();
        private Optional<String> label = Optional.empty();

        private Builder() {}

        public Builder from(CustomField other) {
            key(other.getKey());
            label(other.getLabel());
            return this;
        }

        @JsonSetter("key")
        public Builder key(String key) {
            this.key = Optional.ofNullable(key);
            return this;
        }

        public Builder key(Optional<String> key) {
            this.key = key;
            return this;
        }

        @JsonSetter("label")
        public Builder label(String label) {
            this.label = Optional.ofNullable(label);
            return this;
        }

        public Builder label(Optional<String> label) {
            this.label = label;
            return this;
        }


        public CustomField build() {
            return new CustomField(
                       key,
                       label
                   );
        }
    }

}


