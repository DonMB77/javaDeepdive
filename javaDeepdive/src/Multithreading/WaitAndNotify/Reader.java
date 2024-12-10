package Multithreading.WaitAndNotify;

public class Reader implements Runnable {

    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try {
                System.out.println(name + " waiting to get notified at time: " + System.currentTimeMillis());
                message.wait(); // wait() only functional in synchronized method/block
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " waiting thread got notified at time: " + System.currentTimeMillis());
            System.out.println(name + " processed: " + message.getMessage());
        }
    }
}
