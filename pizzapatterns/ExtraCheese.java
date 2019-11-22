package pizzapatterns;

public class ExtraCheese implements Ingredient {
    private String name;
    private double price;

    public ExtraCheese() {
        this.name = "extra cheese";
        this.price = 1.85;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
