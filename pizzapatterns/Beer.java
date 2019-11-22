package pizzapatterns;

public class Beer implements Ingredient {
    private String name;
    private double price;

    public Beer() {
        this.name = "beer";
        this.price = 3.25;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
