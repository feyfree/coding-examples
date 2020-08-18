package com.feyfree.basic.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    @Test
    public void testList() {
        List<Integer> part1 = new ArrayList<>();
        part1.add(1);
        part1.add(2);
        List<List<Integer>> all = new ArrayList<>();
        all.add(part1);
        System.out.println("----before modified====");
        System.out.println(part1);
        System.out.println(all);
        part1.set(1, 3);
        System.out.println("----after modified");
        System.out.println(part1);
        System.out.println(all);
    }
}
