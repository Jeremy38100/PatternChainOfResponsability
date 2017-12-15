package fr.uga.miage.miageBartender;

import fr.uga.miage.miageBartender.Drink;
import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTest extends TestCase {

    private Ingredient ingredient;

    public void setUp() throws Exception {
        super.setUp();
        this.ingredient = new Ingredient(new Drink("Tequila", EnumDrinkType.Strong), 2);
    }

    @Test
    public void testInvalidIngredientDrink() {
        try {
            new Ingredient(null, 2);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Invalid drink");
        }
    }

    @Test
    public void testInvalidIngredientQuantity() {
        try {
            new Ingredient(new Drink("orange Juice", EnumDrinkType.Soft), -1);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Invalid quantity");
        }
    }

}