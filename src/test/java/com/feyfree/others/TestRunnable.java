package com.feyfree.others;

import org.junit.Test;

public class TestRunnable {

    @Test
    public void testRunnable() throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello, World");
        };
        Thread myThread = new Thread(task);
        myThread.start();
        myThread.join();
        System.out.println("Hi, Java");

    }
}
