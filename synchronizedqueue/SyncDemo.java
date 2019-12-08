package synchronizedqueue;

import java.util.concurrent.locks.ReentrantLock;

public class SyncDemo {

    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        Queue q = new Queue(l, 10);
        int reps = 50;
        Producer pro = new Producer(q, reps);
        Consumer con = new Consumer(q, reps);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        t1.setPriority(10); // assign more priority to Producer
        t2.setPriority(2);  // assign less priority to Consumer
        t1.start();
        t2.run();
    }
}
