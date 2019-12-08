package synchronizedqueue;

public class Consumer implements Runnable {
    private Queue consumerQ;
    private static int REPETITIONS;

    public Consumer(Queue inQ, int reps) {
        consumerQ = inQ;
        REPETITIONS = reps;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<REPETITIONS; i++) {
                Thread.sleep((long)(Math.random() * 1000));
                consumerQ.remove(); // remove node from Queue
            }
            System.exit(0);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
