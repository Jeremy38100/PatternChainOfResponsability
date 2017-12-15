package fr.uga.miage.miageBartender;


import fr.uga.miage.miageBartender.Drink;
import fr.uga.miage.miageBartender.EnumDrinkType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

    private Drink drinkToTest;

    @Before
    public void setUp() throws Exception {
        this.drinkToTest = new Drink("a drink", EnumDrinkType.Soft);
    }

    @After
    public void tearDown() throws Exception {
        this.drinkToTest = null;
    }

    @Test
    public void isAbleToDrinkSoft() {
        this.drinkToTest = new Drink("a drink", EnumDrinkType.Soft);
        Assert.assertTrue(this.drinkToTest.isAbleToDrink(2.0));
    }

    @Test
    public void isAbleToDrinkMedium() {
        this.drinkToTest = new Drink("a drink", EnumDrinkType.Medium);
        Assert.assertTrue(this.drinkToTest.isAbleToDrink(0.1));
    }

    @Test
    public void isNotAbleToDrinkMedium() {
        this.drinkToTest = new Drink("a drink", EnumDrinkType.Medium);
        Assert.assertFalse(this.drinkToTest.isAbleToDrink(1.1));
    }

    @Test
    public void isAbleToDrinkStrong() {
        this.drinkToTest = new Drink("a drink", EnumDrinkType.Strong);
        Assert.assertTrue(this.drinkToTest.isAbleToDrink(0.05));
    }

    @Test
    public void isNotAbleToDrinkStrong() {
        this.drinkToTest = new Drink("a drink", EnumDrinkType.Strong);
        Assert.assertFalse(this.drinkToTest.isAbleToDrink(0.6));
    }
}