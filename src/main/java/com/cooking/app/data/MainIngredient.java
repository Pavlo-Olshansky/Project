package com.cooking.app.data;

import java.util.UUID;

public class MainIngredient {

    private String id;
    private String name;
    private String description;

    public MainIngredient() {
        id = UUID.randomUUID().toString();
    }

    public MainIngredient(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}