package cor;

public class Money {
    int balance;
    int Dollars;
    int Quarters;
    int dimes;
    int Nickels;
    int Pennies;
    Money(double bal){
        Dollars=Quarters=dimes=Nickels=Pennies=0;
        balance = (int) (bal * 100);
    }
    //code for dollar, quarter, dime, nickel and penny handlers
    //5 classes one for each coin
}