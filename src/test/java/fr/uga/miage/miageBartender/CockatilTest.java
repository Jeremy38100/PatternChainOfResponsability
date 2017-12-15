package fr.uga.miage.miageBartender;

import fr.uga.miage.miageBartender.Cockatil;
import fr.uga.miage.miageBartender.Drink;
import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CockatilTest extends TestCase {

    Cockatil cocktailToTest;

    public void setUp() throws Exception {
        super.setUp();
        Drink tequila = new Drink("Tequila", EnumDrinkType.Strong);
        Drink orangeJuice = new Drink("orangeJuice", EnumDrinkType.Soft);
        cocktailToTest = new Cockatil("Tequila Sunrise", Arrays.asList(
                new Ingredient(tequila, 2),
                new Ingredient(orangeJuice, 12)
        ));
    }

    @Test
    public void testIsAbleToDrinkWithStrong0() {
        this.setCocktailWithStrong();
        Assert.assertTrue(this.cocktailToTest.isAbleToDrink(0));
    }

    @Test
    public void testIsAbleToDrinkWithMedium0() {
        this.setCocktailWithMedium();
        Assert.assertTrue(this.cocktailToTest.isAbleToDrink(0));
    }

    @Test
    public void testIsAbleToDrinkWithStrong0_7() {
        this.setCocktailWithStrong();
        Assert.assertFalse(this.cocktailToTest.isAbleToDrink(0.7));
    }

    @Test
    public void testIsAbleToDrinkWithMedium0_7() {
        this.setCocktailWithMedium();
        Assert.assertTrue(this.cocktailToTest.isAbleToDrink(0.7));
    }

    @Test
    public void testIsAbleToDrinkWithStrong2() {
        this.setCocktailWithStrong();
        Assert.assertFalse(this.cocktailToTest.isAbleToDrink(2));
    }

    @Test
    public void testIsAbleToDrinkWithMedium2() {
        this.setCocktailWithMedium();
        Assert.assertFalse(this.cocktailToTest.isAbleToDrink(2));
    }

    private void setCocktailWithStrong() {
        Drink tequila = new Drink("Tequila", EnumDrinkType.Strong);
        Drink orangeJuice = new Drink("orangeJuice", EnumDrinkType.Soft);
        cocktailToTest = new Cockatil("Tequila Sunrise", Arrays.asList(
                new Ingredient(tequila, 2),
                new Ingredient(orangeJuice, 12)
        ));
    }

    private void setCocktailWithMedium() {
        Drink malibu = new Drink("Malibu", EnumDrinkType.Medium);
        Drink pineAppleJuice = new Drink("pineAppleJuice", EnumDrinkType.Soft);
        cocktailToTest = new Cockatil("Malibu Pineapple", Arrays.asList(
                new Ingredient(malibu, 2),
                new Ingredient(pineAppleJuice, 12)
        ));
    }
}