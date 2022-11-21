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
        System.out.println(getMod(10485));
        System.out.println(getMod(15630));
        System.out.println(getMod(17036));
        System.out.println(getMod(19541));
        System.out.println(getMod(24101));


        List<Pair<String, String>> pairs = new ArrayList<>();
        pairs.add(Pair.of("A", null));
        System.out.println(JSONObject.toJSONString(pairs));

        Map<String, String> data = new HashMap<>();
        data.put("a", null);
        System.out.println(data);


    }

    private static int getMod(int consumerId) {
        return (consumerId + "queryUserTextBigDataAB").hashCode() % 100;
    }
}
