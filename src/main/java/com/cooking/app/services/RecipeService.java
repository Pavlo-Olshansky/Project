package com.cooking.app.services;

import java.util.List;

import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.Recipe;
import com.cooking.app.dto.RecipeDto;

public interface RecipeService {

    List<Recipe> getRecipe();

    void deleteRecipe(String recipeId);

    void saveRecipe(RecipeDto recipe) throws DuplicateEntityException;
}
