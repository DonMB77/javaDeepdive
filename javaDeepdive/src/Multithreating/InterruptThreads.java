package Multithreating;

import java.util.concurrent.TimeUnit;

public class InterruptThreads implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("in run() - about to execute work()");
            work();
            System.out.println("in run() - finished work() - due to the nature of work(), this will never be reached.");
        }
        // work() will always throw a InterruptedException, thus we catch it here.
        catch (InterruptedException iE) {
            System.out.println("in run() - interrupted through work()");
            return;
        }
        System.out.println("in run() - doing stuff after nap");
        System.out.println("in run() - leaving as normal");
    }

    public void work() throws InterruptedException {
        while (true) {
            System.out.println("working..");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("isInterrupted() = " + Thread.currentThread().isInterrupted());
                // interrupted() essentially does the same thing, but switches the flag back around. So the flag here would be false again.
                //System.out.println("interrupted() = " + Thread.interrupted());
                //System.out.println("isInterrupted =" + Thread.currentThread().isInterrupted());

                // With this the thread will be interrupted and the InterruptedException will be thrown and the if-clause ends.
                TimeUnit.MILLISECONDS.sleep(1);

                // this will therefor never be reached.
                System.out.println("this line wont be executed.");
            }
        }
    }

    public static void main (String[] args) throws InterruptedException {
        InterruptThreads runnableTask = new InterruptThreads();
        Thread thread = new Thread(runnableTask);
        thread.start();

        Thread.sleep(2000);
        //TimeUnit.MILLISECONDS.sleep(2000);
        //TimeUnit.SECONDS.sleep(2);

        System.out.println("in main() - interrupting another thread");
        thread.interrupt();

        // When we invoke the join() method on a thread, the calling thread goes into a waiting state. It remains in a waiting state until the referenced thread terminates.
        //thread.join();
        System.out.println("in main() - leaving");
    }
}
