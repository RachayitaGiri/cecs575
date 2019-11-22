package fsm;

public class State1 implements State {
    Context currentContext;

    public State1(Context c) {
        System.out.println("State 1");
        currentContext = c;
    }

    @Override
    public void A(){
        currentContext.setState(new State2(currentContext));
    }

    @Override
    public void B(){
        currentContext.setState(new State1(currentContext));
    }

    @Override
    public void C(){
        currentContext.setState(new State1(currentContext));
    }
}
