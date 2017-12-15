package fr.uga.miage.chainOfResponsabilityDistributor;

import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;

public abstract class AbstractDrinkDistributor {

    EnumDrinkType enumDrinkType;

    private AbstractDrinkDistributor nextDistributor;

    public void setNextDistributor(AbstractDrinkDistributor nextDistributor) {
        this.nextDistributor = nextDistributor;
    }

    public void addDrink(Ingredient ingredientToDistribute) {
        if(ingredientToDistribute.getDrink().getType() == this.enumDrinkType) {
            distributeDrink(ingredientToDistribute);
        }
        else if(this.nextDistributor != null) {
            nextDistributor.distributeDrink(ingredientToDistribute);
        }
    }

    abstract protected void distributeDrink(Ingredient ingredientToDistribute);
}
