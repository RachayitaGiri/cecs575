package cor;

public class Dollars extends Handler {
    public void HandleRequest(Money m) {
        if(m.balance>100) {
            m.Dollars = m.balance/100;
            m.balance = m.balance%100;
        }
        else if (successor!=null)
            successor.HandleRequest(m);
    }
}
