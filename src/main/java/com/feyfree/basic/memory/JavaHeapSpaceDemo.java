package com.feyfree.basic.memory;

/**
 * 堆内存异常
 *
 * @author leilei
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String a = "";
        while(true) {
            a += new String(new byte[100 * 2000]);
            a.intern();
        }
    }
}
