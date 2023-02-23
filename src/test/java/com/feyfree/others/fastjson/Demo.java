package com.feyfree.others.fastjson;

import com.alibaba.fastjson.JSONObject;

public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Bob");
        String a = JSONObject.toJSONString(person);
        System.out.println(a);
    }
}
