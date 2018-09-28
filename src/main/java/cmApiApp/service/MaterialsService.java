package cmApiApp.service;

import cmApiApp.exceptions.*;
import cmApiApp.recipes.Recipe;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class MaterialsService {

    private int milk = 1000;
    private int water = 2000;
    private int coffee = 100;

    private final int maxMilk = 1000;
    private final int maxWater = 2000;
    private final int maxCoffee = 100;

    public MaterialsService() {
    }

    public boolean isEnoughMaterials(Recipe recipe) throws ValidationException {

        String exceptionMessage = "";
        int amountOfNotEnough;

        amountOfNotEnough = getMilk(recipe.milk);
        if ( amountOfNotEnough < 0 ) {
            exceptionMessage += "Need %d more milk" + -amountOfNotEnough + "; ";
        }

        amountOfNotEnough = getWater(recipe.water);
        if ( amountOfNotEnough < 0 ) {
            exceptionMessage += "Need %d more water" + -amountOfNotEnough + "; ";
        }

        amountOfNotEnough = getCoffee(recipe.coffee);
        if ( amountOfNotEnough < 0 ) {
            exceptionMessage += "Need %d more coffee" + -amountOfNotEnough + "; ";
        }

        if ( !exceptionMessage.equals("") ) {
            throw new ValidationException(exceptionMessage);
        } else {

            return true;

        }
    }

    public int addMilk(int milk) throws TooMuchException {

        if ( this.milk + milk > maxMilk ) {
            throw new TooMuchException("Milk overflow", maxMilk - this.milk);
        }

        this.milk += milk;

        return this.milk;
    }

    public int addWater(int water) throws TooMuchException {

        if ( this.water + water > maxWater) {
            throw new TooMuchException("Water overflow", maxWater - this.water);
        }

        this.water += water;

        return this.water;
    }

    public int addCoffee(int coffee) throws TooMuchException {

        if ( this.coffee + coffee > maxCoffee ) {
            throw new TooMuchException("Coffee overflow", maxCoffee - this.coffee);
        }

        this.coffee += coffee;

        return this.coffee;
    }

    public int getMilk(int milk) {

        if ( this.milk - milk < 0 ) {
            return this.milk - milk;
        }

        this.milk -= milk;

        return this.milk;
    }

    public int getWater(int water) {

        if (this.water - water < 0) {
            return this.water - water;
        }

        this.water -= water;

        return this.water;
    }

    public int getCoffee(int coffee) {

        if (this.coffee - coffee < 0) {
            return this.coffee - coffee;
        }

        this.coffee -= coffee;

        return this.coffee;
    }

}
