package com.vergilov.recipe.bootstrap;

import com.vergilov.recipe.domain.*;
import com.vergilov.recipe.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


public class DataLoader implements CommandLineRunner {
    private final CategoryService categoryService;
    private final IngredientService ingredientService;
    private final NotesService notesService;
    private final RecipeService recipeService;
    private final UnitOfMeasureService unitOfMeasureService;

    public DataLoader(CategoryService categoryService, IngredientService ingredientService, NotesService notesService,
                      RecipeService recipeService, UnitOfMeasureService unitOfMeasureService) {
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
        this.notesService = notesService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("tablespoon");
        UnitOfMeasure savedUnitOfMeasure = unitOfMeasureService.save(unitOfMeasure);


        Category spicyGrilledChickenCategory = new Category();
        spicyGrilledChickenCategory.setDescription("Mexican");
        Category savedSpicyGrilledChickenCategory = categoryService.save(spicyGrilledChickenCategory);



        Notes spicyGrilledChickenNotes = new Notes();
        spicyGrilledChickenNotes.setRecipeNotes("Warm this really.");
        Notes savedSpicyGrilledChickenNotes = notesService.save(spicyGrilledChickenNotes);

        Recipe spicyGrilledChicken = new Recipe();
        spicyGrilledChicken.setCookTime(40);
        spicyGrilledChicken.setDifficulty(Difficulty.EASY);
        spicyGrilledChicken.setDescription("Spicy Grilled Chicken");
        spicyGrilledChicken.setDirections("BOIL EVERYTHING");
        spicyGrilledChicken.setServings(2);
        spicyGrilledChicken.setNotes(savedSpicyGrilledChickenNotes);
        Recipe savedSpicyGrilledChickenRecipe = recipeService.save(spicyGrilledChicken);

        Ingredient spicyGrilledChickenIngredient = new Ingredient();
        spicyGrilledChickenIngredient.setDescription("Ancho chili powder");
        spicyGrilledChickenIngredient.setAmount(BigDecimal.valueOf(2));
        spicyGrilledChickenIngredient.setUom(unitOfMeasure);
        spicyGrilledChickenIngredient.setRecipe(spicyGrilledChicken);
        Ingredient savedSpicyGrilledChickenIngredient = ingredientService.save(spicyGrilledChickenIngredient);




        Recipe guacamole = new Recipe();
        guacamole.setCookTime(30);
        guacamole.setDifficulty(Difficulty.MODERATE);
        guacamole.setDescription("guacamole");
        guacamole.setDirections("BOIL EVERYTHING AND SMASH");
        Recipe savedGuacamoleRecipe = recipeService.save(guacamole);

        Category guacamoleCategory = new Category();
        guacamoleCategory.setDescription("Fast Food");
        Category savedGuacamoleCategory = categoryService.save(guacamoleCategory);

        Ingredient guacamoleIngredient = new Ingredient();
        guacamoleIngredient.setDescription("Ripe avocados");
        guacamoleIngredient.setAmount(BigDecimal.valueOf(2));
        guacamoleIngredient.setUom(unitOfMeasure);
        guacamoleIngredient.setRecipe(guacamole);
        Ingredient savedGuacamoleIngredient = ingredientService.save(guacamoleIngredient);

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Don't eat alone");
        Notes savedGuacamoleNotes = notesService.save(guacamoleNotes);


    }

}
