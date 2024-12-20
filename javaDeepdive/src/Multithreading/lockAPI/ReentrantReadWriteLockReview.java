package Multithreading.lockAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockReview {

    private Map<String, String> synchronizedHashMap = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();

    public void put(String key, String value) {
        try {
            writeLock.lock();
            synchronizedHashMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public String remove(String key) {
        try {
            writeLock.lock();
            return synchronizedHashMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    public String get (String key) {
        try {
            readLock.lock();
            return synchronizedHashMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public boolean containsKey(String key) {
        try {
            readLock.lock();
            return synchronizedHashMap.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

}
