package com.springframework.Controllers;

import com.springframework.services.IngredientService;
import com.springframework.services.MeasurementsService;
import com.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IngredientControllerTest {


    Model model;
    MockMvc mockMvc;

    @Mock
    IngredientService ingredientService;
    @Mock
    MeasurementsService measurementsService;
    @Mock
    RecipeService recipeService;

    IngredientController ingredientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        ingredientController = new IngredientController(recipeService, ingredientService, measurementsService);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    void newIngredient() {
    }

    @Test
    void listIngredients() {
    }

    @Test
    void showRecipeIngredient() {
    }

    @Test
    void updateRecipeIngredient() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void deleteIngredient() throws Exception{

        mockMvc.perform(get("/recipe/2/ingredient/3/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredients"));

        verify(ingredientService, times(1)).DeleteById(anyLong(),anyLong());
    }
}