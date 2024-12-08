package Multithreading;

public class Yield {

    public static void main (String[] args) {
        var thread0 = new Thread(() -> {
            //gives hint to scheduler that the process is ready to yield its place in the processor
            Thread.yield();
            System.out.println(Thread.currentThread().getName());
        });

        var thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        thread0.start();
        thread1.start();
    }
}
