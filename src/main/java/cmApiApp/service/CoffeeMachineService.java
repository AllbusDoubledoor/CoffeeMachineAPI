package cmApiApp.service;

import cmApiApp.exceptions.TooMuchException;
import cmApiApp.recipes.Recipe;
import cmApiApp.recipes.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class CoffeeMachineService {

    private int cupCounter = 0;

    @Autowired
    MaterialsService materialsService;

    @Autowired
    RecipesService recipesService;

    public String getCoffeeCup(String coffeeName) {

        if ( cupCounter >= 8 ) {

            return "Need cleaning";

        } else {
            try {

                Recipe coffeeRecipe = recipesService.getRecipe(coffeeName);
                materialsService.isEnoughMaterials(coffeeRecipe);
                cupCounter++;

                return String.format("Here is your %s", coffeeName);

            } catch (ValidationException e) {
                return e.getMessage();
            }
        }
    }

    public String addMilk(int amount) {

        try {

            return String.format("Now in coffee machine %dml of milk",
                    materialsService.addMilk(amount));

        } catch (TooMuchException e) {
            return e.getMessage();
        }
    }

    public String addWater(int amount) {

        try {

            return String.format("Now in coffee machine %dml of water",
                    materialsService.addWater(amount));

        } catch (TooMuchException e) {
            return e.getMessage();
        }
    }

    public String addCoffee(int amount) {

        try {

            return String.format("Now in coffee machine %dg of coffee beans",
                    materialsService.addCoffee(amount));
        } catch (TooMuchException e) {
            return e.getMessage();
        }
    }

    public String clean() throws ValidationException {

        int water = -materialsService.getWater(200);

        if ( water < 0 ) {
            throw new ValidationException( String.format("Need %d more water", -water) );
        }

        return "Cleaning complete";
    }
}
