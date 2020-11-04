package com.feyfree.design.singleton;

public class ExecuteThread implements Runnable {
    @Override
    public void run() {
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
