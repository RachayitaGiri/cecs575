package pizzapatterns;

public class GreenPepper implements Ingredient {
    private String name;
    private double price;

    public GreenPepper() {
        this.name = "green pepper";
        this.price = 1.50;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
