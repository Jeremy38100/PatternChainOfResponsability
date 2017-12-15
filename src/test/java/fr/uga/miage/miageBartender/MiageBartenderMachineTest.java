package fr.uga.miage.miageBartender;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class MiageBartenderMachineTest extends TestCase {

    private MiageBartenderMachine machine;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public void setUp() throws Exception {
        super.setUp();
        System.setOut(new PrintStream(outContent));
        this.machine = new MiageBartenderMachine();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        System.setOut(null);
    }

    @Test
    public void testDistributeDrinkSM() {
        Drink malibu = new Drink("Malibu", EnumDrinkType.Medium);
        Drink pineAppleJuice = new Drink("pineAppleJuice", EnumDrinkType.Soft);
        Cockatil cocktail = new Cockatil("Malibu Pineapple", Arrays.asList(
                new Ingredient(malibu, 2),
                new Ingredient(pineAppleJuice, 12)
        ));
        this.machine.distributeCocktail(cocktail);
        assertEquals(
                "MiageBartender add 2.0mL of Malibu" + String.format("%n") +
                        "MiageBartender add 12.0mL of pineAppleJuice" + String.format("%n")
                , outContent.toString()
        );
    }

    @Test
    public void testDistributeDrinkSMS() {
        Drink malibu = new Drink("Malibu", EnumDrinkType.Medium);
        Drink pineAppleJuice = new Drink("pineAppleJuice", EnumDrinkType.Soft);
        Drink vodka = new Drink("vodka", EnumDrinkType.Strong);
        Cockatil cocktail = new Cockatil("Malibu Strong", Arrays.asList(
                new Ingredient(malibu, 2),
                new Ingredient(pineAppleJuice, 12),
                new Ingredient(vodka, 1.5)
        ));
        this.machine.distributeCocktail(cocktail);
        assertEquals(
                "MiageBartender add 2.0mL of Malibu" + String.format("%n") +
                        "MiageBartender add 12.0mL of pineAppleJuice" + String.format("%n") +
                        "MiageBartender add 1.5mL of vodka" + String.format("%n")
                , outContent.toString()
        );
    }
}