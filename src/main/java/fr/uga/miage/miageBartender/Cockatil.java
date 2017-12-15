package fr.uga.miage.miageBartender;

import java.util.List;

public class Cockatil {

    private List<Ingredient> ingredientList;
    private String name;

    public Cockatil(String name, List<Ingredient> ingredientList) {
        this.name = name;
        this.ingredientList = ingredientList;
    }

    public boolean isAbleToDrink(double gramsAlcoholPerLiter) {
        for (Ingredient ingredient : this.ingredientList) {
            if(!ingredient.getDrink().isAbleToDrink(gramsAlcoholPerLiter)) return false;
        }
        return true;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public String getName() {
        return name;
    }
}
