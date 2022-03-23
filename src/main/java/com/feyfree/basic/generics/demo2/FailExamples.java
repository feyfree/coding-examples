package com.feyfree.basic.generics.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * 避免使用 raw types
 * 序列化的时候如果不能确定类型的化， 用 List<?> 作为类型
 *
 * @author leilei
 */
public class FailExamples {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(0));
//        add(strings, Integer.valueOf(0));
        String s = strings.get(0);
        System.out.println(s);
//        System.out.println(strings.get(0));
//        System.out.println(JSONObject.toJSONString(strings));
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }


    private static void add0(List<Object> list, Object o) {
        list.add(o);
    }

}
