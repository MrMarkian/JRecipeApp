package com.springframework.services;

import com.springframework.domain.Recipe;
import com.springframework.domain.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipieImplementation implements RecipieService {


    private final RecipeRepository recipeRepository;

    public RecipieImplementation(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> thisRecipie = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(thisRecipie::add);
        return thisRecipie;
    }
}
