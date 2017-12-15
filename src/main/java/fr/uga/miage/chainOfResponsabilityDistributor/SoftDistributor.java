package fr.uga.miage.chainOfResponsabilityDistributor;

import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;

public class SoftDistributor extends AbstractDrinkDistributor {

    public SoftDistributor() {
        this.enumDrinkType = EnumDrinkType.Soft;
    }

    protected void distributeDrink(Ingredient ingredientToDistribute) {
        // TODO : Send command to the MiageBartender soft drink pipette deliverer
        System.out.println(
                "MiageBartender add " +
                ingredientToDistribute.getQuantity() +
                "mL of " +
                ingredientToDistribute.getDrink().getName()
        );
    }
}
