package fr.uga.miage.chainOfResponsabilityDistributor;

import fr.uga.miage.miageBartender.Drink;
import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MediumDistributorTest extends TestCase {

    private MediumDistributor mediumDitributor;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void setUp() throws Exception {
        super.setUp();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        this.mediumDitributor = new MediumDistributor();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        System.setOut(null);
        System.setErr(null);
    }

    public void testDistributeDrink() {
        String name = "Malibu";
        double quantity = 2.5;
        Ingredient ingredient = new Ingredient(new Drink(name, EnumDrinkType.Medium), quantity);
        this.mediumDitributor.distributeDrink(ingredient);
        assertEquals("MiageBartender add " + quantity + "mL of " + name + String.format("%n"), outContent.toString());
    }
}