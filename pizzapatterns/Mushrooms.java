package pizzapatterns;

public class Mushrooms implements Ingredient {
    private String name;
    private double price;

    public Mushrooms() {
        this.name = "mushrooms";
        this.price = 1.75;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
