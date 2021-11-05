package com.feyfree.work.case001;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 指定区间插入
 *
 * @author leilei
 */
public class Insertion {

    private List<Item> afterInsertion(List<Item> insertions, List<Item> origin, int range) {
        Set<String> insertionSet = insertions.stream().map(Item::getId).collect(Collectors.toSet());
        // 普通商品
        List<Item> normals = origin.stream().filter(o -> !insertionSet.contains(o.getId())).collect(Collectors.toList());
        List<Item> result = new ArrayList<>(origin.size());
        int interval = range / insertions.size();
        // 间隔一定大于1
        if (interval > 1) {
            int temp = 1;
            int i = 0, j = 0;
            while (i < normals.size() && j < insertions.size()) {
                if (temp == interval) {
                    result.add(insertions.get(j));
                    j++;
                    temp = 1;
                } else {
                    result.add(normals.get(i));
                    i++;
                    temp++;
                }
            }
            if (i < normals.size()) {
                System.out.println("补充normal:" + i);
                result.addAll(normals.subList(i, normals.size()));
            }
            if (j < insertions.size()) {
                System.out.println("补充insertion");
                result.addAll(insertions.subList(j, insertions.size()));
            }
            return result;
        }
        return origin;
    }

    public static void main(String[] args) {
        List<Item> origin = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            origin.add(new Item(RandomStringUtils.random(10, true, true)));
        }
        // 从origin 里面拿出来 10个作为 insertion
        int select = 10;
        int remaining = 100;
        List<Item> insertion = new ArrayList<>();
        for (int i = 0; i < remaining; i++) {
            if (new Random().nextInt(100) % (remaining - i) < select) {
                insertion.add(origin.get(i));
                select--;
            }
        }
        System.out.println(insertion.size());
        Insertion f = new Insertion();
        List<Item> result = f.afterInsertion(insertion, origin, 50);
        System.out.println(origin.size());
        System.out.println(result.size());
        // find interval
        f.printIndexes(result, insertion);
        // find missing
        f.findMissing(result, origin);

    }

    private void findMissing(List<Item> result, List<Item> origin) {
        for (int i = 0; i < origin.size(); i++) {
            if (!result.contains(origin.get(i))) {
                System.out.println("迷失的位置:" + i);
            }
        }
    }


    private void printIndexes(List<Item> result, List<Item> compare) {
        for (Item one : compare) {
            System.out.println(result.indexOf(one));
        }
    }
}
