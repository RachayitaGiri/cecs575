package pizzapatterns;

public class GreenOlives implements Ingredient {
    private String name;
    private double price;

    public GreenOlives() {
        this.name = "green olives";
        this.price = 1.35;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
