package statistics;

public class ObserverOne extends Observer{
    ObserverOne(DataSet sub) {
        this.subject = sub;
        subject.addObserver(this);
    }

    public void update () {
        System.out.println("Obs1 is told that DataSet is " + subject.getState());
    }
}
