package pizzapatterns;

public class FamilySizeBase implements Base {
    private String size;
    private double price;

    // static single instance
    private static FamilySizeBase instance = new FamilySizeBase();

    // private constructor: to mandate the need for getInstance()
    private FamilySizeBase() {
        this.size = "Family Size";
        this.price = 16.00;
    }

    // lazy initialization
    public static FamilySizeBase getInstance() {
        if (instance==null)
            return new FamilySizeBase();
        return instance;
    }

    public String getSize() {
        return getInstance().size;
    }

    public double getPrice() {
        return getInstance().price;
    }
}
