package Multithreading.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;

public class ExchangerReview {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Runnable task1 = () -> {
            try {
                String message = exchanger.exchange("Message coming from task1");
                System.out.println("Received from another thread in task1: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                String message = exchanger.exchange("Message coming from task2");
                System.out.println("Received from another thread in task2: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        var executorService = Executors.newCachedThreadPool();
        executorService.submit(task1);
        executorService.submit(task2);

        executorService.shutdown();
    }
}
