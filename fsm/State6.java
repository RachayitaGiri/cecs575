package fsm;

public class State6 implements State {
    Context currentContext;

    public State6(Context c) {
        System.out.println("State 6");
        currentContext = c;
    }

    @Override
    public void A(){
        currentContext.setState(new State5(currentContext));
    }

    @Override
    public void B(){
        currentContext.setState(new State4(currentContext));
    }

    @Override
    public void C(){
        currentContext.setState(new State1(currentContext));
    }
}
