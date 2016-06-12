package com.cooking.app.services;

import java.util.List;

import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.MainIngredient;


public interface CategoryService {

    List<MainIngredient> getCategories();

    void deleteCategory(String categoryId);

    void saveCategory(MainIngredient category) throws DuplicateEntityException;

    MainIngredient getCategoryById(String categoryId);
}
