package pizzapatterns;

public class CanadianBacon implements Ingredient {
    private String name;
    private double price;

    public CanadianBacon() {
        this.name = "Canadian bacon";
        this.price = 2.75;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
