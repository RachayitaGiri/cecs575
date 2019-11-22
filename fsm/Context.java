package fsm;

public class Context {
    State current;

    public Context() {
        current = new State1(this);
    }

    public void setState(State st) {
        current = st;
    }

    public void transition(char ch) {
        if (ch=='a')
            current.A();
        else if (ch=='b')
            current.B();
        else if (ch=='c')
            current.C();
        else {
            System.out.println("The string wasn't accepted.");
            System.exit(0);
        }
    }

}
