package com.feyfree.redis;

public class RedisLockTest {

    private static volatile int add = 10;

    public static void main(String[] args) {

        Runnable handler = () -> {
            RedisLock mylock = new RedisLock("testlock1");
            System.out.println("Connection OK");
            System.out.println(add);
            if (mylock.lock2(200000)) {
                while (add > 0) {
                    System.out.println(Thread.currentThread().toString() + " ———————— add@" + add);
                    add--;
                }
            }
            mylock.unlock();
        };

        new Thread(handler).start();
        new Thread(handler).start();
        new Thread(handler).start();

    }

}