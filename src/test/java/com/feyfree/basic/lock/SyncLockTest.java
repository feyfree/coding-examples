package com.feyfree.basic.lock;

import com.feyfree.basic.concurrent.aqs.SyncLock;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SyncLockTest {
    @Test
    public void testSyncLock() throws InterruptedException {
        final SyncLock lock = new SyncLock();
        for (int i = 0; i < 10; i++) {
//            Thread.sleep(200);
            new Thread(new TestLock(lock), String.valueOf(i)).start();
        }
        Thread.sleep(10000);
    }

    static class TestLock implements Runnable {
        private final SyncLock lock;

        public TestLock(SyncLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                Thread.sleep(100);
                System.out.printf("Thread %s Completed%n", Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    @Test
    public void testUnsafeStateOffset() throws NoSuchFieldException {
        Unsafe unsafe = getUnsafeInstance();
        assert unsafe != null;
        long state = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("state"));
        System.out.println(state);
    }


    private Unsafe getUnsafeInstance() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
