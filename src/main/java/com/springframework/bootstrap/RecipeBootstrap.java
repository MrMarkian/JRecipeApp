package com.springframework.bootstrap;

import com.springframework.domain.*;
import com.springframework.domain.repositories.CatagoryRepository;
import com.springframework.domain.repositories.MeasurementsRepository;
import com.springframework.domain.repositories.RecipeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CatagoryRepository catagoryRepository;
    private final MeasurementsRepository measurementsRepository;
    private final RecipeRepository recipeRepository;

    public RecipeBootstrap(CatagoryRepository catagoryRepository,
                           MeasurementsRepository measurementsRepository,
                           RecipeRepository recipeRepository) {

        this.catagoryRepository = catagoryRepository;
        this.measurementsRepository = measurementsRepository;
        this.recipeRepository = recipeRepository;
    }

    private List<Recipe> getRecipies() {

        List<Recipe> recipies = new ArrayList<>(2);

        Optional<Mesurements> eachMesurementOptional = measurementsRepository.findByUnitOfMeasure("Each");

        if (!eachMesurementOptional.isPresent()) {
            throw new RuntimeException("Each - Measurement not found.. ");
        }

        Optional<Mesurements> teaSpoonMesurementOptional = measurementsRepository.findByUnitOfMeasure("Tea Spoon");

        if (!teaSpoonMesurementOptional.isPresent()) {
            throw new RuntimeException("Tea Spoon - Measurement not found.. ");
        }

        Optional<Mesurements> cupMesurementOptional = measurementsRepository.findByUnitOfMeasure("Cup");

        if (!cupMesurementOptional.isPresent()) {
            throw new RuntimeException("Cup - Measurement not found.. ");
        }

        Optional<Mesurements> PinchMesurementOptional = measurementsRepository.findByUnitOfMeasure("Pinch");

        if (!PinchMesurementOptional.isPresent()) {
            throw new RuntimeException("Pinch - Measurement not found.. ");
        }

        Optional<Mesurements> gramsMesurementOptional = measurementsRepository.findByUnitOfMeasure("Grams");

        if (!gramsMesurementOptional.isPresent()) {
            throw new RuntimeException("Grams- Measurement not found.. ");
        }

        Optional<Mesurements> mlMesurementOptional = measurementsRepository.findByUnitOfMeasure("ml");

        if (!mlMesurementOptional.isPresent()) {
            throw new RuntimeException("ml - Measurement not found.. ");
        }

        Optional<Mesurements> literMesurementOptional = measurementsRepository.findByUnitOfMeasure("Liter");

        if (!literMesurementOptional.isPresent()) {
            throw new RuntimeException("Liter - Measurement not found.. ");
        }

        Optional<Mesurements> KgMesurementOptional = measurementsRepository.findByUnitOfMeasure("Kg");

        if (!KgMesurementOptional.isPresent()) {
            throw new RuntimeException("Kg - Measurement not found.. ");
        }


        //Get Optionals.
        Mesurements eachMes = eachMesurementOptional.get();
        Mesurements teaSpoonMes = teaSpoonMesurementOptional.get();
        Mesurements cupMes = cupMesurementOptional.get();
        Mesurements PinchMes = PinchMesurementOptional.get();
        Mesurements GramsMes = gramsMesurementOptional.get();
        Mesurements mlMes = mlMesurementOptional.get();
        Mesurements literMes = literMesurementOptional.get();
        Mesurements kgMes = KgMesurementOptional.get();


        //get Catagories
        Optional<Catagory> americanCatagoryOptional = catagoryRepository.findByDescription("American");
        Optional<Catagory> mexicanCatagoryOptional = catagoryRepository.findByDescription("Mexican");

        if(!americanCatagoryOptional.isPresent()){
            throw new RuntimeException("American Catagory Not Found.. ");
        }

        if(!mexicanCatagoryOptional.isPresent()){
            throw new RuntimeException("Mexican Catagory Not Found.. ");
        }


        Catagory americanCatagory = americanCatagoryOptional.get();
        Catagory mexicanCatagory = mexicanCatagoryOptional.get();

        //Guacamole Recipie
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Gouacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCooktime(0);
        guacRecipe.setServings(2);
        guacRecipe.setDifficulty(Difficulty.EASY);

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("A tasy, quick and easy snack.. ");
        guacRecipe.setNotes(guacNotes);
        guacRecipe.setDirections("1. Prepare a gas or charcole grill for medium-high, direct heat.\n" +
                "2. Make the marinade and coat the chicken: In a large bowl, stir together the chiili power, oregano, cumin, sugar, salt, garlic and orange zest. Stir in to the chicken.\n"+
                "3. Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest park of the meat registers 165f.\n"+
                "4. Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillit over a medium-high heat. As soon as you see pockets of the air start to form. its done!\n"+
                "5. Assemble the taco: Slice the chicken into strips, On each Torilla, place a small handful or arguala. Top with chicken slices, sliced avocade and raddishes.");


        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredientSet().add(new Ingredient("Ripe Avacodo", new BigDecimal(2), eachMes, guacRecipe));
        guacRecipe.getIngredientSet().add(new Ingredient("Kosher Salt", new BigDecimal(3), PinchMes, guacRecipe));
        guacRecipe.getIngredientSet().add(new Ingredient("fresh lime juice", new BigDecimal(2), teaSpoonMes, guacRecipe));
        guacRecipe.getIngredientSet().add(new Ingredient("minced red onion or thinly sclied standard onion", new BigDecimal(2), eachMes, guacRecipe));
        guacRecipe.getIngredientSet().add(new Ingredient("Chillies, with stems and seeds removed", new BigDecimal(2), eachMes, guacRecipe));
        guacRecipe.getIngredientSet().add(new Ingredient("Black Pepper", new BigDecimal(2), teaSpoonMes, guacRecipe));
        guacRecipe.getIngredientSet().add(new Ingredient("Ripe Tomato, seeds and pulp removed", new BigDecimal(2), eachMes, guacRecipe));

        guacRecipe.getCatagories().add(americanCatagory);
        guacRecipe.getCatagories().add(mexicanCatagory);

        recipies.add(guacRecipe);

        return recipies;
    }

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
          recipeRepository.saveAll(getRecipies());
    }
}
