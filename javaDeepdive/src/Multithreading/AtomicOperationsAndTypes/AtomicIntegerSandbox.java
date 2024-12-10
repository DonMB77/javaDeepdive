package Multithreading.AtomicOperationsAndTypes;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSandbox {

    private static AtomicInteger atomicCounter = new AtomicInteger();

    public static void main (String[] args) throws InterruptedException {
        ArrayList<Thread> allThreadsList = new ArrayList<>();
        int numberOfIncrements = 10000;

        for (int i = 0; i < numberOfIncrements; i++) {
            var thread = new Thread(AtomicIntegerSandbox::incrementCounter);
            allThreadsList.add(thread);
            thread.start();
        }

        for (Thread thread : allThreadsList)
            thread.join();
    }

    public static void incrementCounter() {
        atomicCounter.incrementAndGet();
    }
}
