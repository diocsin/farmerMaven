package by.belarusian.farmer.model.fruits;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Fruit;

public class Apple extends Fruit {

    public static final String rusName = "Яблоко";

    public Apple(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String toString() {
        return "Apple{ " + getColor() + " " + getWeight() + "}";
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
