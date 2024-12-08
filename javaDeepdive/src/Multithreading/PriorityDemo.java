package Multithreading;

public class PriorityDemo {

    public static void main(String[] args) {
        var thread0 = new Thread(PriorityDemo::execute);
        var thread1 = new Thread(PriorityDemo::execute);
        var thread2 = new Thread(PriorityDemo::execute);
        var thread3 = new Thread(PriorityDemo::execute);
        var thread4 = new Thread(PriorityDemo::execute);
        var thread5 = new Thread(PriorityDemo::execute);

        thread0.setPriority(1);
        thread1.setPriority(10);
        thread2.setPriority(10);
        thread3.setPriority(3);
        thread4.setPriority(6);
        thread5.setPriority(4);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static void execute() {
        System.out.println(Thread.currentThread().getName());
    }
}
