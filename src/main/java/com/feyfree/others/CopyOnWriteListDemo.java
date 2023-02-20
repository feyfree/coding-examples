package com.feyfree.others;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListDemo {
    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});
        //[1, 2, 3]
        System.out.println(list);

        //Get iterator 1
        Iterator<Integer> itr1 = list.iterator();

        //Add one element and verify list is updated
        list.add(4);

        //[1, 2, 3, 4]
        System.out.println(list);

        //Get iterator 2
        Iterator<Integer> itr2 = list.iterator();

        System.out.println("====Verify Iterator 1 content====");

        //1,2,3
        itr1.forEachRemaining(System.out::println);

        System.out.println("====Verify Iterator 2 content====");

        //1,2,3,4
        itr2.forEachRemaining(System.out::println);

    }
}
