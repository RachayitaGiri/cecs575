package cor;

public class Pennies extends Handler {
    public void HandleRequest(Money m) {
         m.Pennies = m.balance;
         m.balance = 0;
    }
}
