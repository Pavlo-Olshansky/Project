package com.cooking.app.data;

import java.util.UUID;

public class Ingredient {

    private String id;
    private Integer quantity;
    private ProductDescription foodProduct;
    private Unit unit ;


    public Ingredient() {
        id = UUID.randomUUID().toString();
    }


    public Ingredient(Unit unit, ProductDescription foodProduct, Integer quantity ) {
        this();
        this.foodProduct = foodProduct;
        this.quantity = quantity;
        this.unit = unit;

    }


    public String printIngredient(){
        String line = "" + quantity + unit + "of" + foodProduct;
        System.out.println(line);
        return line;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDescription getFoodProduct(){return foodProduct;}

    public void setFoodProduct(ProductDescription foodProduct){this.foodProduct = foodProduct;}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit(){return unit;}

    public  void setUnit(Unit unit){this.unit = unit;}

}