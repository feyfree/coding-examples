package com.feyfree.basic.thread;

import lombok.SneakyThrows;
import org.junit.Test;

public class TestThread {

    @Test
    public void testJoin() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(100);
                System.out.println("This is a");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is b");
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is c");
            }
        });
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }
}
