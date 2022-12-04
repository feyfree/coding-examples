package com.feyfree.work.case006;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    @Data
    static class Text {
        float a;
    }




    public static void main(String[] args) {
//        System.out.println(getMod(10485));
//        System.out.println(getMod(15630));
//        System.out.println(getMod(17036));
//        System.out.println(getMod(19541));
//        System.out.println(getMod(24101));


        List<List<String>> data = new ArrayList<>();
        List<String> item = new ArrayList<>();
        item.add("1");
        data.add(item);
        System.out.println(data);
        List<List<String>> copied = new ArrayList<>(data);
        data.get(0).add("2");
        System.out.println(copied);





    }

    private static int getMod(int consumerId) {
        return (consumerId + "queryUserTextBigDataAB").hashCode() % 100;
    }
}
