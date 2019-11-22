package pizzapatterns;

public class LargeBase implements Base {
    private String size;
    private double price;

    // static single instance
    private static LargeBase instance = new LargeBase();

    // private constructor: to mandate the need for getInstance()
    private LargeBase() {
        this.size = "Large";
        this.price = 12.00;
    }

    // lazy initialization
    public static LargeBase getInstance() {
        if (instance==null)
            return new LargeBase();
        return instance;
    }

    public String getSize() {
        return getInstance().size;
    }

    public double getPrice() {
        return getInstance().price;
    }
}
