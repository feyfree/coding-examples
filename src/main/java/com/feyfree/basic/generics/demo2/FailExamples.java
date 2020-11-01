package com.feyfree.basic.generics.demo2;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FailExamples {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(0));
        String s = strings.get(0);
        System.out.println(s);
//        System.out.println(strings.get(0));

//        System.out.println(JSONObject.toJSONString(strings));
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
