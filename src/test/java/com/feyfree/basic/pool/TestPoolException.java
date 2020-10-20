package com.feyfree.basic.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestPoolException {

    /**
     * Execute 可以 try-catch
     */
    @Test
    public void testExecuteException() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        try {
            pool.execute(() -> System.out.println(1 / 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  submit future.get()  可以捕获异常
     */
    @Test
    public void testSubmitException() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        try {
//            Future<?> submit = pool.submit(() -> System.out.println(1 / 0));
//            submit.get();
            pool.submit(() -> System.out.println(1 / 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
