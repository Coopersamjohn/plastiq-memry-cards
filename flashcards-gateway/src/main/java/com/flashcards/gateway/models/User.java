package com.flashcards.gateway.models;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private transient String password;


    public User() {
        super();
    }

    public User(
            Builder builder
    ) {
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
    }

    public static class Builder {
        private UUID id;
        private String name;
        private transient String password;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
