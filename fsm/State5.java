package fsm;

public class State5 implements State {
    Context currentContext;

    public State5(Context c) {
        System.out.println("State 5");
        currentContext = c;
    }

    @Override
    public void A(){
        currentContext.setState(new State5(currentContext));
    }

    @Override
    public void B(){
        currentContext.setState(new State6(currentContext));
    }

    @Override
    public void C(){
        currentContext.setState(new State4(currentContext));
    }
}
