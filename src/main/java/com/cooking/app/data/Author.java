package com.cooking.app.data;

import java.util.UUID;

public class Author {

    private String id;
    private String name;
    private String description;
    private String password;


    public Author() {
        id = UUID.randomUUID().toString();
    }

    public Author(String name ,String password, String description) {
        this();
        this.name = name;
        this.description = description;
        this.password = password;
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

    public  String getPassword(){return password;}

    public void setPassword(String password ) {
        this.password = password;
    }

}
