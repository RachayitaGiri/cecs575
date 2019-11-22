package proxy;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        DiscreetString disc = new DiscreetString();

        System.out.println("Enter a string:");

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        disc.setText(text);
        disc.getText();
        disc.reverse();
        disc.close();
    }
}
