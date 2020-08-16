package com.springframework.services;

import com.springframework.commands.IngredientsCommand;
import org.springframework.stereotype.Service;


public interface IngredientService {

    IngredientsCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientsCommand saveIngredientCommand(IngredientsCommand command);
}
