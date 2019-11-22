package fsm;

public class State3 implements State {
    Context currentContext;

    public State3(Context c) {
        System.out.println("State 3");
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
        currentContext.setState(new State4(currentContext));
    }

}
