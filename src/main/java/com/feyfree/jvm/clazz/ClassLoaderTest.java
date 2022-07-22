package com.feyfree.jvm.clazz;


import junit.framework.TestCase;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器测试
 *
 * @author leilei
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("com.feyfree.jvm.clazz.TestClass").getDeclaredConstructor().newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.feyfree.jvm.clazz.TestClass);
        System.out.println(obj.getClass().getClassLoader()); // com.feyfree.jvm.clazz.ClassLoaderTest$1@214c265e
        System.out.println(TestClass.class.getClassLoader()); // jdk.internal.loader.ClassLoaders$AppClassLoader@251a69d7

    }
}
