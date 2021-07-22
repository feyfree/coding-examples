package com.feyfree.basic.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * weak hashmap demo
 *
 * @author leilei
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("--------------------");
        myWeakHashMap();

    }

    private static void myHashMap() {
        Map<Integer, String> map = new HashMap<>();
        String value = "HashMap";
        Integer key = 1;
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);
    }


    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        String value = "HashMap";
        Integer key = new Integer(2);
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();
        System.out.println(map);
        System.gc();
        System.out.println(map.size());
    }
}
