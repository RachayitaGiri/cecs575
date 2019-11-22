package statistics;

abstract class Observer {
    protected DataSet subject;
    abstract void update();
}
