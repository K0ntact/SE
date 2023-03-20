package Tutor1;

import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class NumQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the bound of the queue: ");
        int bound = input.nextInt();
        input.nextLine();

        IntQueue queue = new IntQueue(bound);
        while (true) {
            System.out.println("\n[1] Enqueue");
            System.out.println("[2] Dequeue");
            System.out.println("[3] Print");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a number: ");
                    int num = input.nextInt();
                    input.nextLine();
                    queue.enq(num);
                }
                case 2 -> queue.deq();
                case 3 -> {
                    // Copy the queue to a new queue. Assign q to queue.getQueue() will
                    // only move the reference of the queue to q. So, when we remove
                    // an element from q, it will also be removed from original queue.
                    PriorityBlockingQueue<Integer> q = new PriorityBlockingQueue<>(queue.getQueue());
                    while (!q.isEmpty()) {
                        System.out.print(q.poll() + " ");
                    }
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
