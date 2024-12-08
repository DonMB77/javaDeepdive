package Multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadGroups {

    public static void main (String[] args) throws InterruptedException{

        ThreadGroup threadGroup = new ThreadGroup("threadGroup");

        var thread0 = new Thread(threadGroup, ThreadGroups::execute);
        var thread1 = new Thread(threadGroup, ThreadGroups::execute);
        var thread2 = new Thread(threadGroup, ThreadGroups::execute);
        var thread3 = new Thread(threadGroup, ThreadGroups::execute);
        var thread4 = new Thread(threadGroup, ThreadGroups::execute);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // with this, all threads in this group will be interrupted
        threadGroup.interrupt();
    }

    public static void execute() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
