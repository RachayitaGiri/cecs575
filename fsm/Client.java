package fsm;

import java.util.Scanner;

public class Client {
    static Context context;

    public static void main(String[] args) {
        System.out.println("Enter a string: ");

        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();

        context = new Context();

        for (char c : str) {
            context.transition(c);
        }
        if(context.current instanceof State4 || context.current instanceof State5 || context.current instanceof State6)
            System.out.println("The string was accepted.");
        else
            System.out.println("The string wasn't accepted.");
    }
}
