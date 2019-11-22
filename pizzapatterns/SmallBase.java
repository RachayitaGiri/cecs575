package pizzapatterns;

public class SmallBase implements Base {
    private String size;
    private double price;

    // static single instance
    private static SmallBase instance = new SmallBase();

    // private constructor: to mandate the need for getInstance()
    private SmallBase() {
        this.size = "Small";
        this.price = 8.00;
    }

    // lazy initialization
    public static SmallBase getInstance() {
        if (instance==null)
            return new SmallBase();
        return instance;
    }

    public String getSize() {
        return getInstance().size;
    }

    public double getPrice() {
        return getInstance().price;
    }

}
