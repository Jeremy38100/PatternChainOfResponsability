package fr.uga.miage.chainOfResponsabilityDistributor;

import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;

public class StrongDistributor extends AbstractDrinkDistributor {

    public StrongDistributor() {
        this.enumDrinkType = EnumDrinkType.Strong;
    }

    protected void distributeDrink(Ingredient ingredientToDistribute) {
        // TODO : Send command to the MiageBartender strong alcohol drink pipette deliverer
        System.out.println(
                "MiageBartender add " +
                ingredientToDistribute.getQuantity() +
                "mL of " +
                ingredientToDistribute.getDrink().getName()
        );

    }
}
