package com.springframework.services;

import com.springframework.domain.Recipe;
import com.springframework.domain.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeImplementation implements RecipeService {


    private final RecipeRepository recipeRepository;

    public RecipeImplementation(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> thisRecipie = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(thisRecipie::add);
        return thisRecipie;
    }

    @Override
    public Recipe findById(Long id){
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe not found..");
        }

        return recipeOptional.get();
    }

}
