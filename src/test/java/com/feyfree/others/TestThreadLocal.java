package com.feyfree.others;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThreadLocal {


    private ThreadLocal<String> simpleThreadLocal = new ThreadLocal<>();

    private final Logger logger = LoggerFactory.getLogger(TestThreadLocal.class);

    @Test
    public void testThreadLocal() {
        Thread t = new Thread() {
            final ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("test thread local");
                logger.info(mStringThreadLocal.get());
            }
        };

        t.start();
    }

    @Test
    public void testInheritableThreadLocal() {
        final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("test thread local");
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                logger.info("testInheritableThreadLocal =" + threadLocal.get());
            }
        };

        t.start();
    }


    @Test
    public void testMultiThread() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                simpleThreadLocal.set("Happy");
                logger.info(simpleThreadLocal.get());
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                logger.info(simpleThreadLocal.get());
            }
        };
        thread.start();
        thread2.start();
        Thread.sleep(1000000);
    }


}
