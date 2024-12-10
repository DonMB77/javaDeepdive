package Multithreading.AtomicOperationsAndTypes;

import java.util.concurrent.TimeUnit;

public class InheritableThreadLocalSandbox {
    // here instead of each thread having its own value inside the ThreadLocal
    // The InheritableThreadLocal grands access to values to a thread and all child threads created by that thread.

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main (String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: ");
            threadLocal.set("----Thead 1 - ThreadLocal----");
            inheritableThreadLocal.set("----Thead 1 - InheritableThreadLocal----");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println("ChildThread:");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread 2:");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        });

        thread2.start();
    }
}
