package com.cooking.app.data;

import java.util.UUID;

public class MainInstruction {
    private String id;
    private Integer cookingtime;

    public MainInstruction() {
        id = UUID.randomUUID().toString();
    }

    public MainInstruction(Integer cookingtime) {
        this();
        this.cookingtime = cookingtime ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCookingtime() {
        return cookingtime;
    }

    public void setCookingtime(Integer cookingtime) {
        this.cookingtime = cookingtime;
    }



}
