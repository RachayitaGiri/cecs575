package pizzapatterns;

public class Sausage implements Ingredient {
    private String name;
    private double price;

    public Sausage() {
        this.name = "sausage";
        this.price = 2.00;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
