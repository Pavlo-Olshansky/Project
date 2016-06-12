package com.cooking.app.services;

import java.util.List;
import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.ProductDescription;

public interface DrinksDescriptionService {

    List<ProductDescription> getFoodProduct();

    void deleteFoodProduct(String foodProductId);

    void saveFoodProduct(ProductDescription foodProduct) throws DuplicateEntityException;
}
