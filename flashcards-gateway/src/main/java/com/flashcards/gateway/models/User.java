package com.flashcards.gateway.models;

import java.io.Serializable;
import java.util.Comparator;
import java.util.UUID;

public class User implements Serializable, Comparable<User> {

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

    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public int compareTo(User o) {
        return Comparator.comparing(User::getName)
                .thenComparing(User::getId)
                .compare(this, o);
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
