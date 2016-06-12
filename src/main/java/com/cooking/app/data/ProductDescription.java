package com.cooking.app.data;

import java.util.UUID;

public class ProductDescription {
    private String id;
    private String name;
    private String description;

    public ProductDescription() {
        id = UUID.randomUUID().toString();
    }

    public ProductDescription(String name, String description) {
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
