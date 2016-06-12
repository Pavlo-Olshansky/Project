package com.cooking.app.controller;

import java.io.IOException;
import java.security.InvalidParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cooking.app.data.MainIngredient;
import com.cooking.app.data.ProductDescription;
import com.cooking.app.dto.RecipeDto;
import com.cooking.app.services.CategoryService;
import com.cooking.app.services.DrinksDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cooking.app.services.RecipeService;

@Controller
public class CoctailsController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DrinksDescriptionService foodProductService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        addListsToModel(model);
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        addListsToModel(model);
        return "admin";
    }

    private void addListsToModel(ModelMap model) {
        model.addAttribute("categoryList", categoryService.getCategories());
        model.addAttribute("foodProductList", foodProductService.getFoodProduct());
        model.addAttribute("recipeList", recipeService.getRecipe());
    }

    @RequestMapping(value = "/user/recipe", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String saveRecipeForUser(ModelMap model, @ModelAttribute RecipeDto recipe) throws DuplicateEntityException {
        if (recipe.getName() == null || recipe.getName().isEmpty()) {
            throw new IllegalArgumentException("Name field is empty!");
        }
        if (recipe.getDescription() == null || recipe.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description field is empty!");
        }
        recipeService.saveRecipe(recipe);
        return adminPage(model);
    }

    @RequestMapping(value = "/admin/category", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String saveCategory(ModelMap model, @ModelAttribute MainIngredient category) throws DuplicateEntityException {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new IllegalArgumentException("Name field is empty!");
        }
        if (category.getDescription() == null || category.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description field is empty!");
        }
        categoryService.saveCategory(category);
        return adminPage(model);
    }

    @RequestMapping(value = "/admin/foodProduct", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String saveFoodProduct(ModelMap model, @ModelAttribute ProductDescription foodProduct) throws DuplicateEntityException {
        if (foodProduct.getName() == null || foodProduct.getName().isEmpty()) {
            throw new IllegalArgumentException("Name field is empty!");
        }
        if (foodProduct.getDescription() == null || foodProduct.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description field is empty!");
        }
        foodProductService.saveFoodProduct(foodProduct);
        return adminPage(model);
    }

    @RequestMapping(value = "/admin/foodProduct/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteFoodProduct(@PathVariable("id") String foodProductId) {
        foodProductService.deleteFoodProduct(foodProductId);
        return;
    }

    @RequestMapping(value = "/api/recipe/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRecipe(@PathVariable("id") String recipeId) {
        recipeService.deleteRecipe(recipeId);
        return;
    }

    @RequestMapping(value = "/admin/category/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") String categoryId) {
        categoryService.deleteCategory(categoryId);
        return;
    }


    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex, HttpServletResponse response) {
        try {
            if (ex instanceof InvalidParameterException || ex instanceof IllegalArgumentException
                    || ex instanceof DuplicateEntityException) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}