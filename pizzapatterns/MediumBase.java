package pizzapatterns;

public class MediumBase implements Base {
    private String size;
    private double price;

    // static single instance
    private static MediumBase instance = new MediumBase();

    // private constructor: to mandate the need for getInstance()
    private MediumBase() {
        this.size = "Medium";
        this.price = 10.00;
    }

    // lazy initialization
    public static MediumBase getInstance() {
        if (instance==null)
            return new MediumBase();
        return instance;
    }

    public String getSize() {
        return getInstance().size;
    }

    public double getPrice() {
        return getInstance().price;
    }
}
