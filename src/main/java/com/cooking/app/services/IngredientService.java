package com.cooking.app.services;

import java.util.List;
import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.Ingredient;

public interface IngredientService {

    List<Ingredient> getIngredient();

    void deleteIngredient(String ingredientId);

    void saveIngredient(Ingredient ingredient) throws DuplicateEntityException;
}
