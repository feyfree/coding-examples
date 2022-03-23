package com.feyfree.hadoop.practice;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * map reduce demo
 *
 * @author leilei
 */
public class MapReduceDemo {

    public static void main(String[] args) {
        MapReduceDemo demo = new MapReduceDemo();
//        demo.demo1();
        demo.sqlDemo0();
    }

    private void demo1() {
        // 按行读取配置文件:
        String[] props = new String[]{"profile=native", "debug=true", "logging=warn", "interval=500", "logging=info"};
        Map<String, String> map = Arrays.stream(props)
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return Collections.singletonMap(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }


    /**
     * map reduce 模拟sql
     */
    private void sqlDemo0() {
        int[][] input = new int[][]{
                new int[]{1, 25},
                new int[]{1, 32},
                new int[]{2, 25},
                new int[]{2, 25}};
        Map<String, Integer> result = Arrays.stream(input)
                .map(kv -> Collections.singletonMap(kv[0] + "_" + kv[1], 1))
                .reduce(new HashMap<>(), (m, kv) -> {
                    for (Map.Entry<String, Integer> entry : kv.entrySet()) {
                        if (m.containsKey(entry.getKey())) {
                            m.put(entry.getKey(), m.get(entry.getKey()) + entry.getValue());
                        } else {
                            m.put(entry.getKey(), entry.getValue());
                        }
                    }
                    return m;
                });
        System.out.println(JSONObject.toJSONString(result));
    }


    private void sqlDemo1() {
        // page_id, user_id
        int[][] pageView = new int[][]{
                new int[]{1, 111},
                new int[]{2, 111},
                new int[]{1, 222}};

        // user_id, age
        int[][] userView = new int[][]{
                new int[]{111, 25},
                new int[]{2, 111},
                new int[]{1, 222}};

        // map 阶段
        Map<Integer, String> pm = Arrays.stream(pageView).collect(Collectors.toMap(o -> o[0], o -> "1:" + o[1]));
        Map<Integer, String> um = Arrays.stream(userView).collect(Collectors.toMap(o -> o[0], o -> "2:" + o[1]));
        // shuffle 阶段 把相同user_id 的分到一个地方
        // 操作上面 不是特别符合规范
        pm.putAll(um);

    }
}
