package com.feyfree.work.case002;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MultiLockBySet {

    public static final Map<String, Integer> map = new ConcurrentHashMap<>();

    @Data
    static class Task implements Runnable {
        String name;

        Map<String, Integer> container;

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        System.out.println(map.putIfAbsent("A", 2));
    }


}
