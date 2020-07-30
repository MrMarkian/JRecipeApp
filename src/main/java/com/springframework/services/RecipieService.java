package com.springframework.services;

import com.springframework.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipieService {

    Set<Recipe> getRecipes();

}
