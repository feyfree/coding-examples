package com.feyfree.basic.hash;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试斐波那契散列
 *
 * @author leilei
 */
public class TestFibHash {


    private static final AtomicInteger nextHashCode = new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    @Test
    public void test_idx() {
        int hashCode;
        for (int i = 0; i < 16; i++) {
            hashCode = nextHashCode();
            int idx = hashCode & 15;
            System.out.println("斐波那契散列:" + idx + " 普通散列:" + (String.valueOf(i).hashCode() & 15));
        }
    }

    @Test
    public void test_threadLocalHashCode() throws Exception {
        for (int i = 0; i < 5; i++) {
            ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
            Field threadLocalHashCode = objectThreadLocal.getClass().getDeclaredField("threadLocalHashCode");
            threadLocalHashCode.setAccessible(true);
            System.out.println("objectThreadLocal: " + threadLocalHashCode.get(objectThreadLocal));
        }
    }

}
