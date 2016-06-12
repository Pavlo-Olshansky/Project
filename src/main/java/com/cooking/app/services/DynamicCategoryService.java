package com.cooking.app.services;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.MainIngredient;


@Service
public class DynamicCategoryService implements CategoryService {

    private final Map<String,MainIngredient> categoriesMap = new LinkedHashMap<>();

    @PostConstruct
    public void init() {
        putCategory(new MainIngredient("Водка","Не пальона"));
        putCategory(new MainIngredient("Віскі", "Для мажорів"));
        putCategory(new MainIngredient("Самогон", "Дід зробив"));
        putCategory(new MainIngredient("Кола", "Запівон"));
        putCategory(new MainIngredient("Коньяк", "Вставляє"));
        putCategory(new MainIngredient("Ром", "Для старих піратів"));
    }

    private void putCategory(MainIngredient category) {
        categoriesMap.put(category.getId(), category);
    }

    public List<MainIngredient> getCategories() {
        List<MainIngredient> categoryList = new ArrayList(categoriesMap.values());
        Collections.sort(categoryList, new Comparator<MainIngredient>() {
            @Override
            public int compare(MainIngredient o1, MainIngredient o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return categoryList;
    }

    public void deleteCategory(String categoryId) {
        categoriesMap.remove(categoryId);
    }

    @Override
    public void saveCategory(MainIngredient category) throws DuplicateEntityException {
        for (MainIngredient existing : categoriesMap.values()) {
            if (existing.getName().equals(category.getName()) && !existing.getId().equals(category.getId())) {
                throw new DuplicateEntityException(MainIngredient.class.getSimpleName(), "name", existing.getName());
            }
        }
        categoriesMap.put(category.getId(), category);
    }

    @Override
    public MainIngredient getCategoryById(String categoryId) {
        MainIngredient result = categoriesMap.get(categoryId);
        if (result != null) {
            return result;
        } else {
            throw new IllegalArgumentException("No category with id: " + categoryId);
        }
    }
}

