package com.feyfree.work.case004;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 集合测试
 *
 * @author leilei
 */
public class CollectionLambda {
    public static void main(String[] args) {
        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> a1 = new HashMap<>();
        a1.put("date", "20210101");
        a1.put("用户类型", "A");
        a1.put("活跃类型", "高活");
        a1.put("活跃人数", "a");

        Map<String, String> a2 = new HashMap<>();
        a2.put("date", "20210101");
        a2.put("用户类型", "A");
        a2.put("活跃类型", "低活");
        a2.put("活跃人数", "b");

        Map<String, String> a3 = new HashMap<>();
        a3.put("date", "20210101");
        a3.put("用户类型", "B");
        a3.put("活跃类型", "高活");
        a3.put("活跃人数", "a");

        Map<String, String> a4 = new HashMap<>();
        a4.put("date", "20210101");
        a4.put("用户类型", "B");
        a4.put("活跃类型", "低活");
        a4.put("活跃人数", "b");
        data.add(a1);
        data.add(a2);
        data.add(a3);
        data.add(a4);

        Map<String, List<Map<String, String>>> collect = data.stream().collect(Collectors.groupingBy(o -> o.get("date"), HashMap::new, Collectors.toList()));
        Map<String, Map<String, ?>> result = new HashMap<>();
        for (Map.Entry<String, List<Map<String, String>>> entry : collect.entrySet()) {
            Map<String, List<Map<String, String>>> one = entry.getValue().stream().collect(Collectors.groupingBy(o -> o.get("用户类型"), HashMap::new, Collectors.toList()));
            Map<String, Object> x = new HashMap<>();
            for (Map.Entry<String, List<Map<String, String>>> oneEntry : one.entrySet()) {
                Map<String, String> item = new HashMap<>();
                for (Map<String, String> a : oneEntry.getValue()) {
                    item.put(a.get("活跃类型") + "活跃人数", a.get("活跃人数"));
                }
                x.put(oneEntry.getKey(), item);
            }
            result.put(entry.getKey(), x);
        }
        System.out.println(JSONObject.toJSONString(result));
    }
}
