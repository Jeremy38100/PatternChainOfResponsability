package fr.uga.miage.chainOfResponsabilityDistributor;

import fr.uga.miage.miageBartender.Drink;
import fr.uga.miage.miageBartender.EnumDrinkType;
import fr.uga.miage.miageBartender.Ingredient;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SoftDistributorTest extends TestCase {

    private SoftDistributor softDitributor;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public void setUp() throws Exception {
        super.setUp();
        System.setOut(new PrintStream(outContent));
        this.softDitributor = new SoftDistributor();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        System.setOut(null);
    }

    @Test
    public void testDistributeDrink() {
        String name = "orangeJuice";
        double quantity = 12;
        Ingredient ingredient = new Ingredient(new Drink(name, EnumDrinkType.Soft), quantity);
        this.softDitributor.distributeDrink(ingredient);
        assertEquals("MiageBartender add " + quantity + "mL of " + name + String.format("%n"), outContent.toString());
    }
}