package com.feyfree.others;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThreadLocal {

    private final Logger logger = LoggerFactory.getLogger(TestThreadLocal.class);

    @Test
    public void testThreadLocal() {
        Thread t = new Thread() {
            final ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("test thread local");
                mStringThreadLocal.get();
            }
        };

        t.start();
    }

    @Test
    public void testInheritableThreadLocal() {
        final ThreadLocal threadLocal = new InheritableThreadLocal<>();
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


}
