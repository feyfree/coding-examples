package com.feyfree.basic.random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class RandomCode {
    public static void main(String[] args) {
        Set<String> data = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < 3; j++) {
                String randomData = RandomStringUtils.random(6, true, true);
                randomData = StringUtils.lowerCase(randomData);
                System.out.println(randomData);
                if (!data.contains(randomData)) {
                    data.add(randomData);
                    break;
                }
            }

        }
        System.out.println(data.size());
        System.out.println(data.iterator().next());
    }
}
