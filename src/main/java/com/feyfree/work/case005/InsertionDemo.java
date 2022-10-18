package com.feyfree.work.case005;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionDemo {
    public static void main(String[] args) {
        List<String> normals = Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6"});
        List<String> insertions = Arrays.asList(new String[]{"a", "b", "c", "d"});
        int groupA = 3;
        int groupB = 3;
        int countA = 0;
        int countB = 0;
        int indexA = 0;
        int indexB = 0;
        List<String> data = new ArrayList<>();
        while (data.size() < normals.size() + insertions.size()) {
            while (countA < groupA && indexA < insertions.size()) {
                data.add(insertions.get(indexA));
                indexA++;
                countA++;
            }
            countA = 0;
            while (countB < groupB && indexB < normals.size()) {
                data.add(normals.get(indexB));
                indexB++;
                countB++;
            }
            countB = 0;
        }
        System.out.println(JSONObject.toJSONString(data));
    }
}
