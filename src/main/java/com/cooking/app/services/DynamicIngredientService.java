package com.cooking.app.services;

import java.util.*;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.Ingredient;

@Service
public class DynamicIngredientService implements IngredientService {

    private final Map<String, Ingredient> ingredientHashMap = new LinkedHashMap<>();

    @PostConstruct
    public void init() {
        putIngredient(new Ingredient());
    }

    private void putIngredient(Ingredient ingredient) {
        ingredientHashMap.put(ingredient.getId(), ingredient);
    }

    public List<Ingredient> getIngredient() {
        List<Ingredient> ingredientList = new ArrayList(ingredientHashMap.values());
        return ingredientList;

    }

    public void deleteIngredient(String ingredientId) {
        ingredientHashMap.remove(ingredientId);
    }

    @Override
    public void saveIngredient(Ingredient ingredient) throws DuplicateEntityException {

/*        for (Ingredient existing : ingredientHashMap.values()) {
            if (existing.getFoodProduct().equals(ingredient.getFoodProduct()) && existing.getId().equals(ingredient.getId())) {
                do
                {
                    (existing.getQuantity().equals(ingredient.getQuantity()) && !existing.getId().equals(ingredient.getId()))
                }
                throw new DuplicateEntityException(Ingredient.class.getSimpleName(), "name", existing.getName());
            }
        }

        ingredientHashMap.put(ingredient.getId(), ingredient);
        */
    }

}


