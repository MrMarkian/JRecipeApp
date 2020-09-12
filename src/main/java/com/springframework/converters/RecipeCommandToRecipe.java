package com.springframework.converters;

import com.springframework.commands.RecipeCommand;
import com.springframework.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConveter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConveter, IngredientCommandToIngredient ingredientConverter,
                                 NotesCommandToNotes notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setCookTime(source.getCooktime());
        recipe.setPrepTime(source.getPreptime());
        recipe.setDescription(source.getDescription());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setImage(source.getImage());
        recipe.setNotes(notesConverter.convert(source.getNotes()));



        if (source.getCatagoryCommands() != null && source.getCatagoryCommands().size() > 0){
            source.getCatagoryCommands()
                    .forEach( category -> recipe.getCategories().add(categoryConveter.convert(category)));
        }

        if (source.getIngredientsCommandSet() != null && source.getIngredientsCommandSet().size() > 0){
            source.getIngredientsCommandSet()
                    .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
