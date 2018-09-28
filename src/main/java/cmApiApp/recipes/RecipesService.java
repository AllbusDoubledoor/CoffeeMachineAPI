package cmApiApp.recipes;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RecipesService {

    private static HashMap<String, Recipe> recipes;

    static {
        recipes = new HashMap<>();
        recipes.put("cappuccino", new Recipe(100, 150, 15));
        recipes.put("americano", new Recipe(0, 250, 15));
        recipes.put("espresso", new Recipe(0, 50, 15));
        recipes.put("double espresso", new Recipe(0, 50, 30));
    }

    public void addRecipe(String name, int milk, int water, int coffee) {
        recipes.put( name, new Recipe(milk, water, coffee) );
    }

    public Recipe getRecipe(String name) {
        return recipes.get(name);
    }

}
