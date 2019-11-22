package pizzapatterns;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactory {
    private Base base;
    private List<Ingredient> toppings = new ArrayList<>();

    // create the base of the pizza: S, M, L, F
    public Base createBase(int type) {
        switch (type) {
            case 1:
                base = SmallBase.getInstance();
                break;
            case 2:
                base = MediumBase.getInstance();
                break;
            case 3:
                base = LargeBase.getInstance();
                break;
            case 4:
                base = FamilySizeBase.getInstance();
                break;
            default:
                base = SmallBase.getInstance();
                break;
        }
        return base;
    }

    // add ingredients to the pizza
    public List<Ingredient> addIngredients(List<Character> topList) {
        for (Character c : topList) {
            switch (c) {
                case 'p':
                    toppings.add(new Pepperoni());
                    break;
                case 's':
                    toppings.add(new Sausage());
                    break;
                case 'h':
                    toppings.add(new Hamburger());
                    break;
                case 'c':
                    toppings.add(new CanadianBacon());
                    break;
                case 'e':
                    toppings.add(new ExtraCheese());
                    break;
                case 'o':
                    toppings.add(new Onions());
                    break;
                case 'g':
                    toppings.add(new GreenPepper());
                    break;
                case 'b':
                    toppings.add(new BlackOlives());
                    break;
                case 'n':
                    toppings.add(new GreenOlives());
                    break;
                case 'm':
                    toppings.add(new Mushrooms());
                    break;
                case 'a':
                    toppings.add(new Anchovies());
                    break;
                case 'r':
                    toppings.add(new Beer());
                    break;
            }
        }
        return toppings;
    }


}
