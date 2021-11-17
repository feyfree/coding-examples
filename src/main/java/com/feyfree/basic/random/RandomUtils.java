package com.feyfree.basic.random;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机函数
 *
 * @author leilei
 */
public class RandomUtils {

    /**
     * 从n中选出m个
     *
     * @param m
     * @param n
     * @return
     */
    public static List<Integer> random1(int m, int n) {
        List<Integer> result = new ArrayList<>();
        int remaining = n;
        int select = m;
        for (int i = 0; i < n; i++) {
            int mod = Math.abs((new Random().nextInt()) % remaining);
            if (mod < select) {
                result.add(i);
                select--;
            }
            remaining--;
        }
        System.out.println(JSONObject.toJSONString(result));
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            RandomUtils.random1(10, 100);

        }
    }
}
