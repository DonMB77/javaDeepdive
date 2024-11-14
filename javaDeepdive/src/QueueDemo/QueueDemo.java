package QueueDemo;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

    public static void main (String[] args) {
        // PriorityQueue automatically sorts elements in their natural order.
        Queue<Integer> queue = new PriorityQueue<>();

        queue.offer(2);
        queue.offer(8);
        queue.offer(3);
        queue.offer(1);
        queue.offer(10);

        System.out.println("Get head of queue and remove element: " + queue.poll()); // 1
        System.out.println("Size of the queue after poll(): " + queue.size()); // 4
        System.out.println("peek(): " + queue.peek()); // 2
    }
}
