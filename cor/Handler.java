package cor;

public abstract class Handler {
    protected Handler successor;
    public  Handler() {
        successor = null;
    }
    void SetSuccessor(Handler successor){
        this.successor = successor;
    }
    public abstract void HandleRequest(Money m);
}

