package com.feyfree.others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestRandom {

    @Test
    public void test() {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
//        test.add(3);
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        for (int i = 0; i < 10000; i++) {
            if (generateRandomFirstAd(test) == 0) {
                aNum++;
            } else if (generateRandomFirstAd(test) == 1) {
                bNum++;
            } else if (generateRandomFirstAd(test) == 2) {
                cNum++;
            }
        }
        System.out.println("anum : " + aNum + "---" + "bnum:" + bNum + "---" + "cnum : " + cNum);
    }


    private Integer generateRandomFirstAd(List<Integer> ads) {
        List<Integer> weightList = ads.stream().map(o -> 11 - o).collect(Collectors.toList());
        int sum = weightList.stream().mapToInt(Integer::intValue).sum();
        int randomIndex = new Random().nextInt(sum);
        System.out.println("random====" + randomIndex);
        int start = 0;
        for (int i = 0; i < weightList.size(); i++) {
            start += weightList.get(i);
            if (start >= randomIndex) {
                return i;
            }

        }
        return 0;
    }

    @Test
    public void randomInt() {
        int index = Math.abs(new Random().nextInt(10));
        System.out.println(index);
    }
}
