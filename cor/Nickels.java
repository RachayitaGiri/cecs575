package cor;

public class Nickels extends Handler {
    public void HandleRequest(Money m) {
        if(m.balance>5) {
            m.Nickels = m.balance/5;
            m.balance = m.balance%5;
        }
        else if (successor!=null)
            successor.HandleRequest(m);
    }
}
