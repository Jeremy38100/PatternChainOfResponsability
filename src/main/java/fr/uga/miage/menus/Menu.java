package fr.uga.miage.menus;

import fr.uga.miage.miageBartender.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public Menu() {

        List<Cockatil> cocktails = getCocktails();

        MiageBartenderMachine bartender = new MiageBartenderMachine();
        Cockatil cockatilToCreate;

        while (true) {
            printSeparator();
            printSeparator();
            double alcoholValue = this.getAlcoholLevel();
            cockatilToCreate = this.chooseCocktail(cocktails, alcoholValue);
            System.out.println("Creation of the cocktail " + cockatilToCreate.getName());
            bartender.distributeCocktail(cockatilToCreate);
            System.out.println("Enjoy your Dink ! 🍹");
        }
    }

    private double getAlcoholLevel() {
        System.out.println("Please use the alcohol tester");
        System.out.println("[Press ENTER to blow]");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Math.floor((Math.random()*2) * 100) / 100; // TODO Link to the alcohol sensor of the MiageBartender machine
    }

    private Cockatil chooseCocktail(List<Cockatil> cocktails, double gramsAlcoholPerLiter) {
        Scanner reader = new Scanner(System.in);

        int nbCocktail = 0;
        int nbSelected;
        List<Integer> cocktailsAbleToDrink = new ArrayList<Integer>();
        for (Cockatil cockatil : cocktails) {
            if(cockatil.isAbleToDrink(gramsAlcoholPerLiter)) {
                cocktailsAbleToDrink.add(nbCocktail);
            }
            nbCocktail++;
        }
        do {
            printMessageAlcoholTest(gramsAlcoholPerLiter);
            printSeparator();
            System.out.println("Please select the cokctail by the number: ");

            for (Integer nbCocktailAbleToDrink : cocktailsAbleToDrink) {
                System.out.println(
                        nbCocktailAbleToDrink + ": " +
                        cocktails.get(nbCocktailAbleToDrink).getName()
                );
            }
            nbSelected = reader.nextInt();
        }  while (isSelectionInvalid(nbSelected, cocktailsAbleToDrink));
        return cocktails.get(nbSelected);
    }

    private boolean isSelectionInvalid(int nbSelected, List<Integer> cocktails) {
        System.out.println(cocktails.indexOf(nbSelected));
        return cocktails.indexOf(nbSelected) < 0;
    }

    private List<Cockatil> getCocktails() {
        Drink cola = new Drink("Cola", EnumDrinkType.Soft);
        Drink orangeJuice = new Drink("Orange Juice", EnumDrinkType.Soft);
        Drink pineappleJuice = new Drink("Pineapple Juice", EnumDrinkType.Soft);
        Drink applejuice = new Drink("Apple Juice", EnumDrinkType.Soft);
        Drink lemonade = new Drink("Lemonade", EnumDrinkType.Soft);
        Drink grenadineSyrup = new Drink("Grenadine Syrup", EnumDrinkType.Soft);
        Drink starwberrySyrup = new Drink("Strawberry Syrup", EnumDrinkType.Soft);

        Drink malibu = new Drink("Malibu", EnumDrinkType.Medium);
        Drink beer = new Drink("Beer", EnumDrinkType.Medium);
        Drink manzanna = new Drink("Manzanna", EnumDrinkType.Medium);

        Drink vodka = new Drink("Vodka", EnumDrinkType.Strong);
        Drink rhum = new Drink("Rhum", EnumDrinkType.Strong);
        Drink chartreuse = new Drink("Chartreuse", EnumDrinkType.Strong);
        Drink whisky = new Drink("Whisky", EnumDrinkType.Strong);

        Cockatil whiskyCoca = new Cockatil("Whisky Coca", Arrays.asList(
                new Ingredient(whisky, 2),
                new Ingredient(cola, 8)
        ));

        Cockatil chartreuseExperience = new Cockatil("Chartreuse Experience", Arrays.asList(
                new Ingredient(chartreuse, 2),
                new Ingredient(vodka, 2),
                new Ingredient(orangeJuice, 10)
        ));

        Cockatil malibuSun = new Cockatil("Malibu Sun", Arrays.asList(
                new Ingredient(malibu, 5),
                new Ingredient(orangeJuice, 7)
        ));

        Cockatil malibuTropical= new Cockatil("Malibu Tropcial", Arrays.asList(
                new Ingredient(malibu, 4),
                new Ingredient(pineappleJuice, 12)
        ));

        Cockatil strawBeery= new Cockatil("StrawBeery", Arrays.asList(
                new Ingredient(beer, 10),
                new Ingredient(starwberrySyrup, 2)
        ));

        Cockatil appleMojito = new Cockatil("Apple Mojito", Arrays.asList(
                new Ingredient(manzanna, 6),
                new Ingredient(applejuice, 2),
                new Ingredient(lemonade, 6)
        ));

        Cockatil planterPunch = new Cockatil("Planter's punch", Arrays.asList(
                new Ingredient(rhum, 6),
                new Ingredient(orangeJuice, 4),
                new Ingredient(grenadineSyrup, 1)
        ));

        Cockatil tropicalJuice = new Cockatil("Tropical Juice", Arrays.asList(
                new Ingredient(grenadineSyrup, 2),
                new Ingredient(orangeJuice, 4),
                new Ingredient(pineappleJuice, 6)
        ));

        return Arrays.asList(
                whiskyCoca,
                chartreuseExperience,
                malibuSun,
                malibuTropical,
                strawBeery,
                appleMojito,
                planterPunch,
                tropicalJuice
        );
    }

    private void printMessageAlcoholTest(double gramsAlcoholPerLiter) {
        String message = "Choose one you want !";
        if(gramsAlcoholPerLiter > 0.5) message = "It's your last drink, let's slow down";
        if(gramsAlcoholPerLiter > 1) message = "Let's try our soft cocktails for the moment !";

        System.out.println("Your alcohol level is " + gramsAlcoholPerLiter + "g/L");
        System.out.println(message);
    }

    private void printSeparator() {
        System.out.println("-----------------------------");
    }
}
