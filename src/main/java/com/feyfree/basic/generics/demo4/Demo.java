package com.feyfree.basic.generics.demo4;

import java.util.Arrays;


/**
 * 数组是协变的
 *
 * https://zh.wikipedia.org/wiki/%E5%8D%8F%E5%8F%98%E4%B8%8E%E9%80%86%E5%8F%98
 *
 * @author leilei
 */
public class Demo {
    public static void main(String[] args) {
        String[] a = new String[1];
        a[0] = "Happy";
        Object[] b = a;
        System.out.println(Arrays.toString(b));
        // ----Not work for input new item 运行时候才能报错
        // b[0] = 1;
        // --------------------------------
        // Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
        //	at com.feyfree.basic.generics.demo4.Demo.main(Demo.java:12)


    }
}
