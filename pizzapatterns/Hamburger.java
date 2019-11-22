package pizzapatterns;

public class Hamburger implements Ingredient {
    private String name;
    private double price;

    public Hamburger() {
        this.name = "hamburger";
        this.price = 2.00;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
