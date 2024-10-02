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
@JsonDeserialize(builder = Contact.Builder.class)
public final class Contact {
    private final Optional<String> email;
    private final Optional<String> firstName;
    private final Optional<String> id;
    private final Optional<String> lastName;
    private final Optional<String> source;
    private final Optional<Boolean> subscribed;
    private final Optional<String> userGroup;
    private final Optional<String> userId;

    private Contact(
        Optional<String> email,
        Optional<String> firstName,
        Optional<String> id,
        Optional<String> lastName,
        Optional<String> source,
        Optional<Boolean> subscribed,
        Optional<String> userGroup,
        Optional<String> userId
    ) {
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.source = source;
        this.subscribed = subscribed;
        this.userGroup = userGroup;
        this.userId = userId;
    }

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getEmail() {
        return email.orElse(null);
    }

    @JsonProperty("firstName")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getFirstName() {
        return firstName.orElse(null);
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id.orElse(null);
    }

    @JsonProperty("lastName")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getLastName() {
        return lastName.orElse(null);
    }

    @JsonProperty("source")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getSource() {
        return source.orElse(null);
    }

    @JsonProperty("subscribed")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getSubscribed() {
        return subscribed.orElse(null);
    }

    @JsonProperty("userGroup")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUserGroup() {
        return userGroup.orElse(null);
    }

    @JsonProperty("userId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUserId() {
        return userId.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof Contact && equalTo((Contact) other);
    }

    private boolean equalTo(Contact other) {
        return
            email.equals(other.email) &&

            firstName.equals(other.firstName) &&

            id.equals(other.id) &&

            lastName.equals(other.lastName) &&

            source.equals(other.source) &&

            subscribed.equals(other.subscribed) &&

            userGroup.equals(other.userGroup) &&

            userId.equals(other.userId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.email,
                   this.firstName,
                   this.id,
                   this.lastName,
                   this.source,
                   this.subscribed,
                   this.userGroup,
                   this.userId
               );
    }

    @Override
    public String toString() {
        return "Contact{" +
               "email=" + email +
               "firstName=" + firstName +
               "id=" + id +
               "lastName=" + lastName +
               "source=" + source +
               "subscribed=" + subscribed +
               "userGroup=" + userGroup +
               "userId=" + userId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> email = Optional.empty();
        private Optional<String> firstName = Optional.empty();
        private Optional<String> id = Optional.empty();
        private Optional<String> lastName = Optional.empty();
        private Optional<String> source = Optional.empty();
        private Optional<Boolean> subscribed = Optional.empty();
        private Optional<String> userGroup = Optional.empty();
        private Optional<String> userId = Optional.empty();

        private Builder() {}

        public Builder from(Contact other) {
            email(other.getEmail());
            firstName(other.getFirstName());
            id(other.getId());
            lastName(other.getLastName());
            source(other.getSource());
            subscribed(other.getSubscribed());
            userGroup(other.getUserGroup());
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

        @JsonSetter("firstName")
        public Builder firstName(String firstName) {
            this.firstName = Optional.ofNullable(firstName);
            return this;
        }

        public Builder firstName(Optional<String> firstName) {
            this.firstName = firstName;
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

        @JsonSetter("lastName")
        public Builder lastName(String lastName) {
            this.lastName = Optional.ofNullable(lastName);
            return this;
        }

        public Builder lastName(Optional<String> lastName) {
            this.lastName = lastName;
            return this;
        }

        @JsonSetter("source")
        public Builder source(String source) {
            this.source = Optional.ofNullable(source);
            return this;
        }

        public Builder source(Optional<String> source) {
            this.source = source;
            return this;
        }

        @JsonSetter("subscribed")
        public Builder subscribed(Boolean subscribed) {
            this.subscribed = Optional.ofNullable(subscribed);
            return this;
        }

        public Builder subscribed(Optional<Boolean> subscribed) {
            this.subscribed = subscribed;
            return this;
        }

        @JsonSetter("userGroup")
        public Builder userGroup(String userGroup) {
            this.userGroup = Optional.ofNullable(userGroup);
            return this;
        }

        public Builder userGroup(Optional<String> userGroup) {
            this.userGroup = userGroup;
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


        public Contact build() {
            return new Contact(
                       email,
                       firstName,
                       id,
                       lastName,
                       source,
                       subscribed,
                       userGroup,
                       userId
                   );
        }
    }

}


