package com.feyfree.design.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestEnum {

    @Test
    public void testEnumReflect() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<EnumSingleton> clazz = EnumSingleton.class;
        Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.newInstance();
    }

    @Test
    public void testEnumReflect2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<EnumSingleton> clazz = EnumSingleton.class;
        Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.newInstance();
    }
}
