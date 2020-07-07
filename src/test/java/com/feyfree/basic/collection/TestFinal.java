package com.feyfree.basic.collection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试final 属性
 *
 * @author leilei
 */
public class TestFinal {

    public final Integer info = 123;

    @Test
    public void testListOf() {
        List<Integer> init = new ArrayList<>();
        init.add(1);
        init.add(2);
        // 不可修改
        List<Integer> integers = Collections.unmodifiableList(init);
        integers.add(3);
    }

    @Test
    public void testAccessible() throws NoSuchFieldException, IllegalAccessException {
        TestFinal testFinal = new TestFinal();
        Field field = testFinal.getClass().getDeclaredField("info");
        field.setAccessible(true);
        field.set(testFinal, 789);
        System.out.println(field.get(testFinal));
        System.out.println(testFinal.info);
        System.out.println(info);
    }
}
