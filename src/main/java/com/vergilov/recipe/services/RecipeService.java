package com.vergilov.recipe.services;

import com.vergilov.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
