package com.feyfree.basic.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 资源类
 */
@Slf4j
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object val) {
        readWriteLock.writeLock().lock();
        try {
            // Do write
        } catch (Exception e) {
            log.error("");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            // Do read
        } catch (Exception e) {
            log.error("");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

/**
 * 读写锁例子
 *
 * @author leilei
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {

    }
}
