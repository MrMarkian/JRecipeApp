package com.springframework.Controllers;

import com.springframework.commands.IngredientsCommand;
import com.springframework.commands.MeasurementCommand;
import com.springframework.commands.RecipeCommand;
import com.springframework.services.IngredientService;
import com.springframework.services.MeasurementsService;
import com.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final MeasurementsService   measurementsService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, MeasurementsService measurementsService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.measurementsService = measurementsService;
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/new")
    public String newIngredient(@PathVariable String recipeId, Model model){

        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));
        //todo raise exception if null
        IngredientsCommand ingredientsCommand = new IngredientsCommand();
        ingredientsCommand.setRecipeId(Long.valueOf(recipeId));

        model.addAttribute("ingredient", ingredientsCommand);
        ingredientsCommand.setMeasurementCommand(new MeasurementCommand());
        model.addAttribute("measurements", measurementsService.listAllMeasurements());

        return "recipe/ingredient/ingredientform";

    }


    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
        log.debug("Ingredient Conroller: Getting List of Ingredients..");
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredient/list";
    }


    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        log.debug("Ingredient Controller:Showing Ingredient..");
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        log.debug("Ingredient Controller: Updating Ingredient : " + id);
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        model.addAttribute("measurements", measurementsService.listAllMeasurements());

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping
    @RequestMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientsCommand command)
    {
        IngredientsCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("Saved recipe id:" + savedCommand.getId());
        log.debug("Saved ingredient id:"+ savedCommand.getId());

        return  "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{id}/delete")
    public String deleteIngredient(@PathVariable String  recipeId, @PathVariable String id)
    {
        log.debug("Deleting ingredient id:" + id);
        ingredientService.DeleteById(Long.valueOf(recipeId), Long.valueOf(id));
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }

}
