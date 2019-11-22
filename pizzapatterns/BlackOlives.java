package pizzapatterns;

public class BlackOlives implements Ingredient {
    private String name;
    private double price;

    public BlackOlives() {
        this.name = "black olives";
        this.price = 1.50;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
