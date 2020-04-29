package com.feyfree.others;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWSample {
    private final Map<String, String> m = new TreeMap<>();

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock r = rwl.readLock();

    private final Lock w = rwl.writeLock();

    public void get(String key) {
        try {
            r.lock();
            System.out.println("read lock is locked");
        } finally {
            r.unlock();
        }
    }

}
