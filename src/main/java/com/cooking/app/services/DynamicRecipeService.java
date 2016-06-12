package com.cooking.app.services;

import java.util.*;

import javax.annotation.PostConstruct;

import com.cooking.app.data.*;


import com.cooking.app.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cooking.app.controller.DuplicateEntityException;


@Service
public class DynamicRecipeService implements RecipeService {

    private final Map<String, Recipe> recipes = new LinkedHashMap<>();

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IngredientService ingredientService;

    @PostConstruct
    public void init() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        Recipe recipe3 = new Recipe();
        recipe1.setName("Викрутка");
        recipe1.setDescription("Водка, Сік");
        recipe2.setName("Дон Коньячіно");
        recipe2.setDescription("Коньяк, Водка, Лід");
        recipe3.setName("Пивний негідник");
        recipe3.setDescription("Сік, Пиво, Водка");
        recipe1.setAuthor(authorService.getAuthors().get(0));
        recipe1.setCategory(categoryService.getCategories().get(0));
        recipe1.setInstruction(new MainInstruction());
        putRecipe(recipe1);

        recipe2.setAuthor(authorService.getAuthors().get(1));
        recipe2.setCategory(categoryService.getCategories().get(3));
        recipe2.setInstruction(new MainInstruction());
        putRecipe(recipe2);

        recipe3.setAuthor(authorService.getAuthors().get(0));
        recipe3.setCategory(categoryService.getCategories().get(0));
        recipe3.setInstruction(new MainInstruction());
        putRecipe(recipe3);
    }

    private void putRecipe(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
    }

    public List<Recipe> getRecipe() {
        List<Recipe> recipeList = new ArrayList(recipes.values());
        Collections.sort(recipeList, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return recipeList;
    }

    public void deleteRecipe(String recipeId) {
        recipes.remove(recipeId);
    }

    @Override
    public void saveRecipe(RecipeDto recipeDto) throws DuplicateEntityException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Recipe newRecipe = new Recipe();
        newRecipe.setName(recipeDto.getName());
        newRecipe.setDescription(recipeDto.getDescription());

        MainIngredient category = categoryService.getCategoryById(recipeDto.getCategoryId());
        newRecipe.setCategory(category);

        Author author = authorService.getAuthorByName(authentication.getName());
        newRecipe.setAuthor(author);

        for (Recipe existing : recipes.values()) {
            if (existing.getName().equals(newRecipe.getName()) && !existing.getId().equals(newRecipe.getId())) {
                throw new DuplicateEntityException(Recipe.class.getSimpleName(), "name", existing.getName());
            }
        }
        recipes.put(newRecipe.getId(), newRecipe);
    }


}


