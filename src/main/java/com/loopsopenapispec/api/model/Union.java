package com.loopsopenapispec.api.model;

import java.util.Objects;

import com.loopsopenapispec.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = Union.Deserializer.class)
public final class Union {
    private final Object value;

    private Union(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isTransactionalFailureResponseVariant() {
        return value instanceof TransactionalFailureResponse;
    }

    public TransactionalFailureResponse asTransactionalFailureResponseVariant() {
        return isTransactionalFailureResponseVariant() ? (TransactionalFailureResponse) value : null;
    }

    public boolean isTransactionalFailure2ResponseVariant() {
        return value instanceof TransactionalFailure2Response;
    }

    public TransactionalFailure2Response asTransactionalFailure2ResponseVariant() {
        return isTransactionalFailure2ResponseVariant() ? (TransactionalFailure2Response) value : null;
    }

    public boolean isTransactionalFailure3ResponseVariant() {
        return value instanceof TransactionalFailure3Response;
    }

    public TransactionalFailure3Response asTransactionalFailure3ResponseVariant() {
        return isTransactionalFailure3ResponseVariant() ? (TransactionalFailure3Response) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Union that = (Union) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Union of(Object value) {
        if (value instanceof TransactionalFailureResponse ||
                value instanceof TransactionalFailure2Response || value instanceof TransactionalFailure3Response) {
            return new Union(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends com.fasterxml.jackson.databind.JsonDeserializer<Union> {
        @Override
        public Union deserialize(com.fasterxml.jackson.core.JsonParser p,
                                 com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return Union.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return Union.of(ObjectMappers.JSON_MAPPER.convertValue(value, TransactionalFailureResponse.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return Union.of(ObjectMappers.JSON_MAPPER.convertValue(value, TransactionalFailure2Response.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return Union.of(ObjectMappers.JSON_MAPPER.convertValue(value, TransactionalFailure3Response.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}

