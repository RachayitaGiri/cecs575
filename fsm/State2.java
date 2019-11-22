package fsm;

public class State2 implements State {
    Context currentContext;

    public State2(Context c) {
        System.out.println("State 2");
        currentContext = c;
    }

    @Override
    public void A(){
        currentContext.setState(new State2(currentContext));
    }

    @Override
    public void B(){
        currentContext.setState(new State3(currentContext));
    }

    @Override
    public void C(){
        currentContext.setState(new State1(currentContext));
    }
}
