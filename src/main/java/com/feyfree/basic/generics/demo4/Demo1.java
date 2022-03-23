package com.feyfree.basic.generics.demo4;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Object[] objectArray = new Long[1];
        // Throws ArrayStoreException
        objectArray[0] = "I don't fit in";

        // Won't compile!
        // Incompatible types
//        List<Object> ol = new ArrayList<Long>();
//        ol.add("I don't fit in");

    }
}
