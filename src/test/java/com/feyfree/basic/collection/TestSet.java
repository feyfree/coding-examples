package com.feyfree.basic.collection;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

    @Test
    public void testRetainAll() {
        Set<String> a = new HashSet<>();
        a.add("1");
        a.add("2");
        Set<String> b = new HashSet<>();
        b.add("1");
        b.add("3");
        a.retainAll(b);
        System.out.println(JSONObject.toJSONString(a));
    }
}
