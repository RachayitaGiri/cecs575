package cor;

public class Dimes extends Handler {
    public void HandleRequest(Money m) {
        if(m.balance>10) {
            m.dimes = m.balance/10;
            m.balance = m.balance%10;
        }
        else if (successor!=null)
            successor.HandleRequest(m);
    }
}
