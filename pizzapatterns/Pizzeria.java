package pizzapatterns;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class Pizzeria extends JFrame{
    private PizzaFactory factory;

    Pizzeria(PizzaFactory f) {
        this.factory = f;
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {  // handler
                if(ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.out.println("Cancelling order...");
                    System.exit(0);
                }
            }
        });
    }

    public void orderPizza(int type, List<Character> additionalIng) {
        Base base = factory.createBase(type);
        List<Ingredient> tops = factory.addIngredients(additionalIng);

        displayOrder(base, tops);
    }

    public void displayOrder(Base base, List<Ingredient> tops) {
        double total = base.getPrice();

        System.out.print("Order: ");
        System.out.print(base.getSize() + " with ");

        // print the ingredients comma separated
        StringJoiner joiner = new StringJoiner(", ");
        for (Ingredient i : tops) {
            total += i.getPrice();
            joiner.add(i.getName());
        }
        System.out.print(joiner.toString());

        // print the total amount due
        System.out.println(" - $" + total);

        // print the number of ingredients
        System.out.println("\t   " + tops.size() + " ingredients");
        System.out.println("End order");
    }

    public void displayBaseMenu() {
        System.out.println("1. Small\t$8.00");
        System.out.println("2. Medium\t$10.00");
        System.out.println("3. Large\t$12.00");
        System.out.println("4. Family\t$16.00");
    }

    public void displayIngredientMenu() {
        System.out.println(String.format("%-20s $%2.2f", "(P)epperoni", 2.00));
        System.out.println(String.format("%-20s $%2.2f", "(S)ausage", 2.00));
        System.out.println(String.format("%-20s $%2.2f", "(H)amburger", 2.00));
        System.out.println(String.format("%-20s $%2.2f", "(C)anadian Bacon", 2.75));
        System.out.println(String.format("%-20s $%2.2f", "(E)xtra Cheese", 1.85));
        System.out.println(String.format("%-20s $%2.2f", "(O)nions", 1.50));
        System.out.println(String.format("%-20s $%2.2f", "(G)reen Pepper", 1.50));
        System.out.println(String.format("%-20s $%2.2f", "(B)lack Olives", 1.50));
        System.out.println(String.format("%-20s $%2.2f", "Gree(n) Olives", 1.35));
        System.out.println(String.format("%-20s $%2.2f", "(M)ushrooms", 1.75));
        System.out.println(String.format("%-20s %-6s", "(A)nchovies", "Free!"));
        System.out.println(String.format("%-20s $%2.2f", "Bee(r)", 3.25));
    }

    public static void main(String[] args) {
        Pizzeria pizzaPatterns = new Pizzeria(new PizzaFactory());
        System.out.println("To cancel ordering at any time, press ESC when the GUI window is in focus.\n");

        System.out.println("Enter the number for the base pizza");
        pizzaPatterns.displayBaseMenu();

        Scanner sc = new Scanner(System.in);
        int baseType = sc.nextInt();

        System.out.println("\nAdd any combination of ingredients by pressing the corresponding key in parenthesis:");
        pizzaPatterns.displayIngredientMenu();

        String combo = sc.next();

        List<Character> topList = new ArrayList<>();
        for (int i=0; i<combo.length(); i++)
            topList.add(combo.charAt(i));

        pizzaPatterns.orderPizza(baseType, topList);
        System.exit(0);
    }

}
