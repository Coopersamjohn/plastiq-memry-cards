package com.flashcards.gateway.models;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

public class Category implements Serializable, Comparable<Category> {

    private Long id;
    private HashSet<UUID> setIds;
    private String name;

    public Category() {
        super();
    }

    @Override
    public int compareTo(@NotNull Category o) {
        return this.name.compareTo(o.name);
    }
}
