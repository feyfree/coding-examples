package com.feyfree.basic.map;

/**
 * 测试map 类的基础方法
 *
 * @author leilei
 */
public class MapBasicFunction {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static void main(String[] args) {
        MapBasicFunction basic = new MapBasicFunction();
        int size = basic.tableSizeFor(17);
        System.out.println(size);
    }
}
