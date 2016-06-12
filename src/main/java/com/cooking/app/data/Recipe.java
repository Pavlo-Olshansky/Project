package com.cooking.app.data;

import java.util.UUID;

public class Recipe {

    private String id;
    private String name;
    private String description;
    private Author author;
    private MainIngredient category;
    private Ingredient ingredient;
    private MainInstruction instruction;

    public Recipe() {
        id = UUID.randomUUID().toString();
    }

    public Recipe(String name, String description , Author author, MainIngredient category , Ingredient ingredient, MainInstruction instruction ) {
        this();
        this.name = name;
        this.description = description;
        this.author = author;
        this.category = category;
        this.ingredient = ingredient;
        this.instruction = instruction;
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

    public MainIngredient getCategory() {
        return category;
    }

    public void setCategory(MainIngredient category){this.category = category;}

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {this.author = author;}

    public Ingredient getIngredient() {return ingredient;}

    public void setIngredient(Ingredient ingredient) {this.ingredient = ingredient;}

    public MainInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(MainInstruction instruction) {this.instruction = instruction;}

}


