import javax.swing.*;

public class HelloWorld {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hello, world! 'Tis the beginning of the GUI era!");
        String numTxt1, numTxt2;
        int num1=0, num2=0;
        numTxt1 = JOptionPane.showInputDialog(null, "Enter number 1:");
        try {
            num1 = Integer.parseInt(numTxt1);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Invalid integer.");
        }
        numTxt2 = JOptionPane.showInputDialog(null, "Enter number 2:");
        try {
            num2 = Integer.parseInt(numTxt2);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Invalid integer.");
        }
        JOptionPane.showMessageDialog(null, (num1)+", "+(num2));
    }
}
