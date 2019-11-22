package pizzapatterns;

public class Pepperoni implements Ingredient {
    private String name;
    private double price;

    public Pepperoni() {
        this.name = "pepperoni";
        this.price = 2.00;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
