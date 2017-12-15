package fr.uga.miage.miageBartender;

public class Drink {
    private String name;
    private EnumDrinkType type;

    public Drink(String name, EnumDrinkType type) {
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public EnumDrinkType getType() {
        return type;
    }

    public boolean isAbleToDrink(double gramsAlcoholPerLiter) {
        if (this.type == EnumDrinkType.Medium) return gramsAlcoholPerLiter < 1;
        else if (this.type == EnumDrinkType.Strong) return gramsAlcoholPerLiter < 0.5;
        return true;
    }
}
