package synchronizedqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue {
    private Node front, rear;
    private int nodeCount=0;
    private Lock qLock;
    private int limit;
    private Condition isFullCondition;
    private Condition isEmptyCondition;

    public Queue(ReentrantLock inLock, int lim) {
        front = null;
        rear = null;
        qLock = inLock;
        limit = lim;
        isFullCondition = qLock.newCondition();
        isEmptyCondition = qLock.newCondition();
    }

    public void add(String s) {
        qLock.lock();
        try {
            while (isFull()) {
                try {
                    System.out.println("Waiting on dequeue...");
                    isFullCondition.await();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            Node newNode = new Node(s);

            if (rear==null) {
                front = newNode;
                rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
            nodeCount++;
            System.out.println(String.format("Enqueuing %s nodeCount = %d",
                    s, nodeCount));

            isEmptyCondition.signalAll();
        }
        finally {
            qLock.unlock();
        }

    }

    public void remove() {
        qLock.lock();
        try {

            while (isEmpty()) {
                try {
                    System.out.println("Waiting on enqueue...");
                    isEmptyCondition.await();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            if (front==null)
                return;

            Node removedNode = front;
            front = front.next;

            if (front==null)
                rear=null;

            System.out.println(String.format("Dequeuing %s nodeCount = %d",
                    removedNode.getData(), nodeCount));
            nodeCount--;

            isFullCondition.signalAll();

        }
        finally {
            qLock.unlock();
        }
    }

    public Boolean isFull() {
        return nodeCount==limit;
    }

    public Boolean isEmpty() {
        return nodeCount==0;
    }
}
