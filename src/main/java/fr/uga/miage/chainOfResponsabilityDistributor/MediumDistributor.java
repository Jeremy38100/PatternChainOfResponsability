package fr.uga.miage.chainOfResponsabilityDistributor;

import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;

public class MediumDistributor extends AbstractDrinkDistributor {

    public MediumDistributor() {
        this.enumDrinkType = EnumDrinkType.Medium;
    }

    protected void distributeDrink(Ingredient ingredientToDistribute) {
        // TODO : Send command to the MiageBartender medium alcohol drink pipette deliverer
        System.out.println(
                "MiageBartender add " +
                ingredientToDistribute.getQuantity() +
                "mL of " +
                ingredientToDistribute.getDrink().getName()
        );
    }
}
