package synchronizedqueue;

import java.util.Date;

public class Producer implements Runnable {
    private Queue producerQ;
    private static int REPETITIONS;

    public Producer(Queue inQ, int reps) {
        producerQ = inQ;
        REPETITIONS = reps;
    }

    @Override
    public void run() {
        try {
            for (int i=1; i<=REPETITIONS; i++) {
                // add node to Queue
                producerQ.add(new Date().toString());
                Thread.sleep((long)(Math.random() * 1000));
                System.out.println(String.format("Processing #%d", i));
            }
            System.exit(0);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
