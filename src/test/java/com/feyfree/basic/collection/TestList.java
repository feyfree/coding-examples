package com.feyfree.basic.collection;

import com.google.common.collect.Lists;
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

    @Test
    public void testListsPartition() {
        int total = 6;
        int taskNum = 5;
        List<Integer> data = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            data.add(1);
        }
        int size = total / taskNum == 0 ? 1 : total / taskNum + 1;
        List<List<Integer>> partition = Lists.partition(data, size);
        System.out.println(partition.size());
        for (List<Integer> item : partition) {
            System.out.println(item.size());
        }
    }

    @Test
    public void testMyList() {
        MyList myList = new MyList();
        List<Integer> data = new ArrayList<>();
        myList.setMyList(data);
        data.add(1);
        System.out.println(myList.getMyList().get(0));
        System.out.println("-------------");
        MyList myList2 = new MyList();
        myList2.setMyList(new ArrayList<>(2));
        List<Integer> list = myList2.getMyList();
        list.add(1);
        System.out.println(myList2.getMyList().size());
    }


    private List<Integer> getItems() {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        return data.subList(1, 2);
    }

    @Test
    public void test() {
        List<Integer> data = getItems();
        System.out.println(data);
        System.out.println(data.size());
    }
}
