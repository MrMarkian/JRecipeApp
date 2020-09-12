package com.springframework.bootstrap;

import com.springframework.domain.*;
import com.springframework.repositories.CatagoryRepository;
import com.springframework.repositories.MeasurementsRepository;
import com.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Profile("default")
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

        Optional<Mesurements> eachMesurementOptional = measurementsRepository.findByDescription("Each");

        if (!eachMesurementOptional.isPresent()) {
            throw new RuntimeException("Each - Measurement not found.. ");
        }

        Optional<Mesurements> teaSpoonMesurementOptional = measurementsRepository.findByDescription("Tea Spoon");

        if (!teaSpoonMesurementOptional.isPresent()) {
            throw new RuntimeException("Tea Spoon - Measurement not found.. ");
        }

        Optional<Mesurements> cupMesurementOptional = measurementsRepository.findByDescription("Cup");

        if (!cupMesurementOptional.isPresent()) {
            throw new RuntimeException("Cup - Measurement not found.. ");
        }

        Optional<Mesurements> PinchMesurementOptional = measurementsRepository.findByDescription("Pinch");

        if (!PinchMesurementOptional.isPresent()) {
            throw new RuntimeException("Pinch - Measurement not found.. ");
        }

        Optional<Mesurements> gramsMesurementOptional = measurementsRepository.findByDescription("Grams");

        if (!gramsMesurementOptional.isPresent()) {
            throw new RuntimeException("Grams- Measurement not found.. ");
        }

        Optional<Mesurements> mlMesurementOptional = measurementsRepository.findByDescription("ml");

        if (!mlMesurementOptional.isPresent()) {
            throw new RuntimeException("ml - Measurement not found.. ");
        }

        Optional<Mesurements> literMesurementOptional = measurementsRepository.findByDescription("Liter");

        if (!literMesurementOptional.isPresent()) {
            throw new RuntimeException("Liter - Measurement not found.. ");
        }

        Optional<Mesurements> KgMesurementOptional = measurementsRepository.findByDescription("Kg");

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
        guacRecipe.setCookTime(0);
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

        guacRecipe.getIngredients().add(new Ingredient("Ripe Avacodo", new BigDecimal(2), eachMes, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher Salt", new BigDecimal(3), PinchMes, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice", new BigDecimal(2), teaSpoonMes, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sclied standard onion", new BigDecimal(2), eachMes, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Chillies, with stems and seeds removed", new BigDecimal(2), eachMes, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Black Pepper", new BigDecimal(2), teaSpoonMes, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Ripe Tomato, seeds and pulp removed", new BigDecimal(2), eachMes, guacRecipe));

        guacRecipe.getCategories().add(americanCatagory);
        guacRecipe.getCategories().add(mexicanCatagory);

        recipies.add(guacRecipe);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MEDIUM);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.getIngredients().add(new Ingredient("Ancho Chili Powder", new BigDecimal(2), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(1), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(".5"), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("finely grated orange zestr", new BigDecimal(1), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Olive Oil", new BigDecimal(2), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("boneless chicken thighs", new BigDecimal(4), teaSpoonMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("small corn tortillasr", new BigDecimal(8), eachMes, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("packed baby arugula", new BigDecimal(3), cupMes, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), eachMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), PinchMes, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), eachMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupMes,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachMes,tacosRecipe));

        tacosRecipe.getCategories().add(americanCatagory);
        tacosRecipe.getCategories().add(mexicanCatagory);

        tacosRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacosRecipe.setServings(4);
        tacosRecipe.setSource("Simply Recipes");

        recipies.add(tacosRecipe);

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
