package statistics;

class ObserverTwo extends Observer {
    ObserverTwo(DataSet sub) {
        subject = sub;
        subject.addObserver(this);
    }
    public void update () {
        System.out.println("Obs2 is trying to ignore the fact that DataSet is " + subject.getState());
    }
}
