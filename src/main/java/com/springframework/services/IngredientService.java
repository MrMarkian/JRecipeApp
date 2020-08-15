package com.springframework.services;

import com.springframework.commands.IngredientsCommand;

public interface IngredientService {

    IngredientsCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientsCommand saveIngredientCommand(IngredientsCommand command);
}
