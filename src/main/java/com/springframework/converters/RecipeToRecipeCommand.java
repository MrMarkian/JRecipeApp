package com.springframework.converters;

import com.springframework.commands.RecipeCommand;
import com.springframework.domain.Catagory;
import com.springframework.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{

    private final CategoryToCategoryCommand categoryConveter;
    private final com.springframework.converters.IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConveter, IngredientToIngredientCommand ingredientConverter,
                                 NotesToNotesCommand notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {


        final RecipeCommand command = new RecipeCommand();
        command.setId(source.getId());
        command.setCooktime(source.getCookTime());
        command.setPreptime(source.getPrepTime());
        command.setDescription(source.getDescription());
        command.setDifficulty(source.getDifficulty());
        command.setDirections(source.getDirections());
        command.setServings(source.getServings());
        command.setSource(source.getSource());
        command.setUrl(source.getUrl());
        command.setImage(source.getImage());
        command.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach((Catagory category) -> command.getCatagoryCommands().add(categoryConveter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach(ingredient -> command.getIngredientsCommandSet().add(ingredientConverter.convert(ingredient)));
        }

        return command;
    }
}
