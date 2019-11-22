package cor;

public class Quarters extends Handler {
    public void HandleRequest(Money m) {
        if(m.balance>25) {
            m.Quarters = m.balance/25;
            m.balance = m.balance%25;
        }
        else if (successor!=null)
            successor.HandleRequest(m);
    }
}
