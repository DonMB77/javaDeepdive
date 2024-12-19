package Multithreading.lockAPI;

import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTypeReview {

    private static final int CAPACITY = 5;

    private Deque<String> stack = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition stackEmptyCondition = lock.newCondition();
    private Condition stackFullCondition = lock.newCondition();

    public static void main (String[] args) throws InterruptedException {
        var demo = new ConditionTypeReview();
        var executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> System.out.println(demo.popFromStack()));
        executorService.submit(() -> System.out.println("Test String One"));

        executorService.shutdown();
    }

    public void pushToStack (String item) {
        try {
            lock.lock();
            while (stack.size() == CAPACITY); {
                stackFullCondition.await();
            }
            stack.push(item);
            stackEmptyCondition.signalAll();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String popFromStack() {
        try {
            lock.lock();
            while (stack.size() == 0) {
                stackEmptyCondition.await();
            }
            return stack.pop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stackFullCondition.signalAll();
            lock.unlock();
        }
        return "";
    }
}
