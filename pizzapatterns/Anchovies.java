package pizzapatterns;

public class Anchovies implements Ingredient {
    private String name;
    private double price;

    public Anchovies() {
        this.name = "anchovies";
        this.price = 0.00;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
