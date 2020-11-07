package com.feyfree.classic.loadbalance;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLoadBalance {

    public List<Pair<String, Integer>> createData() {
        List<Pair<String, Integer>> data = new ArrayList<>();
        data.add(Pair.of("A", 5));
        data.add(Pair.of("B", 2));
        data.add(Pair.of("C", 1));
        Pair<String, Integer> item = Pair.of("D", 0);
        item.setValue(1);
        return data;
    }

    @Test
    public void testRandomLoadBalance() {
        RandomLoadBalance balance = new RandomLoadBalance();
        balance.initData(createData());
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < 1000; i++) {
            String invoker = balance.getInvoker();
            if (invoker.equals("A")) {
                a++;
            } else {
                if (invoker.equals("B")) {
                    b++;
                } else {
                    c++;
                }
            }
        }
        System.out.println("A:" + a + "B:" + b + "C:" + c);
    }
}
