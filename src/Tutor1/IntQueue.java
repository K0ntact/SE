package Tutor1;

import java.util.concurrent.PriorityBlockingQueue;

public class IntQueue {
    private PriorityBlockingQueue<Integer> queue;

    public IntQueue(Integer n) {
        this.queue = new PriorityBlockingQueue<>(n);
    }

    public void enq(Integer n) {
        this.queue.add(n);
    }

    public void deq() {
        this.queue.remove();
    }

    public PriorityBlockingQueue<Integer> getQueue() {
        return queue;
    }
}
