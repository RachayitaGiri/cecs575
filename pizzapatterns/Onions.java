package pizzapatterns;

public class Onions implements Ingredient {
    private String name;
    private double price;

    public Onions() {
        this.name = "onions";
        this.price = 1.50;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
