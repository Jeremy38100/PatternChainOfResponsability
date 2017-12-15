package fr.uga.miage.miageBartender;

import fr.uga.miage.chainOfResponsabilityDistributor.AbstractDrinkDistributor;
import fr.uga.miage.chainOfResponsabilityDistributor.MediumDistributor;
import fr.uga.miage.chainOfResponsabilityDistributor.SoftDistributor;
import fr.uga.miage.chainOfResponsabilityDistributor.StrongDistributor;

public class MiageBartenderMachine {

    public void distributeCocktail(Cockatil cockatil) {
        for (Ingredient ingredient : cockatil.getIngredientList()) {
            this.distributeDrink(ingredient);
        }
    }

    private void distributeDrink(Ingredient ingredient) {
        getChainDistributor().addDrink(ingredient);
    }

    private static AbstractDrinkDistributor getChainDistributor() {
        AbstractDrinkDistributor softDistributor = new SoftDistributor();
        AbstractDrinkDistributor mediumDistributor = new MediumDistributor();
        AbstractDrinkDistributor strongDistributor = new StrongDistributor();

        softDistributor.setNextDistributor(mediumDistributor);
        mediumDistributor.setNextDistributor(strongDistributor);

        return softDistributor;
    }

}
