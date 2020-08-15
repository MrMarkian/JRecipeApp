package com.springframework.converters;

import com.springframework.commands.IngredientsCommand;
import com.springframework.domain.Ingredient;
import com.springframework.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientsCommand, Ingredient> {

    private final MeasureCommandToMesurment uomConverter;

    @Autowired
    public IngredientCommandToIngredient(MeasureCommandToMesurment uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientsCommand source) {

        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());

        if (source.getRecipeId() != null) {
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }

        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setMesurements(uomConverter.convert(source.getMeasurementCommand()));
        return ingredient;

    }
}


