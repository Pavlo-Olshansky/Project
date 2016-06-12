package com.cooking.app.services;

import java.util.*;

import javax.annotation.PostConstruct;

import com.cooking.app.data.ProductDescription;
import org.springframework.stereotype.Service;

import com.cooking.app.controller.DuplicateEntityException;

@Service
public class DynamicDrinksDescriptionService implements DrinksDescriptionService {

    private final Map<String, ProductDescription> foodProductMap = new LinkedHashMap<>();

    @PostConstruct
    public void init() {
        putFoodProduct(new ProductDescription("Водка", "Алькогольний"));
        putFoodProduct(new ProductDescription("Пиво", "Слобоалкогольний"));
        putFoodProduct(new ProductDescription("Лимон", "Смакова добавка"));
    }

    private void putFoodProduct(ProductDescription foodProduct) {
        foodProductMap.put(foodProduct.getId(), foodProduct);
    }

    public List<ProductDescription> getFoodProduct() {
        List<ProductDescription> foodProductList = new ArrayList(foodProductMap.values());
        Collections.sort(foodProductList, new Comparator<ProductDescription>() {
            @Override
            public int compare(ProductDescription o1, ProductDescription o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return foodProductList;

    }

    public void deleteFoodProduct(String foodProductId) {
        foodProductMap.remove(foodProductId);
    }

    @Override
    public void saveFoodProduct(ProductDescription foodProduct) throws DuplicateEntityException {
        for (ProductDescription existing : foodProductMap.values()) {
            if (existing.getName().equals(foodProduct.getName()) && !existing.getId().equals(foodProduct.getId())) {
                throw new DuplicateEntityException(ProductDescription.class.getSimpleName(), "name", existing.getName());
            }
        }
        foodProductMap.put(foodProduct.getId(), foodProduct);
    }

}
