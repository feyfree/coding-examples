package com.feyfree.work.case001;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 指定区间插入
 * <p>
 * 1. 新品出现在前50, 先筛掉
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


    private List<Item> afterInsertion2(List<Item> insertions, List<Item> origin, int range) {
        Set<String> insertionSet = insertions.stream().map(Item::getId).limit(Math.min(origin.size(), insertions.size())).collect(Collectors.toSet());
        // 普通商品
        List<Item> normals = origin.stream().filter(o -> !insertionSet.contains(o.getId())).collect(Collectors.toList());
        List<Item> result = new ArrayList<>(origin.size());

        System.out.println("新品数据:" + JSONObject.toJSONString(insertions.stream().map(Item::getId).collect(Collectors.toList())));
        System.out.println("全部数据" + JSONObject.toJSONString(origin.stream().map(Item::getId).collect(Collectors.toList())));
        int interval = range / insertions.size();
        // 间隔一定大于1
        if (interval > 1) {
            // 分桶
            // calculate relative index
            Item[] container = new Item[range];
            int bucketIndex = 0;
            int prev = -1;
            for (int i = 0; i < origin.size(); i++) {
                Item item = origin.get(i);
                if (insertionSet.contains(item.getId())) {
                    container[bucketIndex * interval + i % interval] = item;
                    insertionSet.remove(item.getId());
                    prev = i;
                }
                if (i > 0 && (i + 1) % interval == 0) {
                    if (i - prev < interval) {
                        bucketIndex++;
                    }
                }
            }
            int i = 0, j = 0;
            while (i < normals.size() && j < container.length) {
                if (container[j] == null) {
                    container[j] = normals.get(i);
                    i++;
                } else {
                    j++;
                }
            }
            result.addAll(Arrays.stream(container).filter(Objects::nonNull).collect(Collectors.toList()));
            result.addAll(normals.subList(i, normals.size()));
            System.out.println("插值后顺序" + JSONObject.toJSONString(result.stream().map(Item::getId).collect(Collectors.toList())));
            return result;
        }
        return origin;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"687658", "710874", "707215", "721100", "706959", "715499", "538464", "538511"};
        String[] newItems = new String[]{"700921"};
        List<Item> data = Arrays.stream(input).map(Item::new).collect(Collectors.toList());
        List<Item> insertion = Arrays.stream(newItems).map(Item::new).collect(Collectors.toList());
        data.addAll(insertion);
        Insertion f = new Insertion();
        System.out.println(JSONObject.toJSONString(insertion));
        List<Item> result = f.afterInsertion2(insertion, data, 5);
        System.out.println(JSONObject.toJSONString(result));

    }

    private void findMissing(List<Item> result, List<Item> origin) {
        for (int i = 0; i < origin.size(); i++) {
            if (!result.contains(origin.get(i))) {
                System.out.println("迷失的位置:" + i);
            }
        }
        List<Item> sortedOrigin = origin.stream().sorted(Comparator.comparing(Item::getId)).collect(Collectors.toList());
        List<Item> sortedResult = result.stream().sorted(Comparator.comparing(Item::getId)).collect(Collectors.toList());
        for (int i = 0; i < sortedResult.size(); i++) {
            if (!sortedOrigin.get(i).equals(sortedResult.get(i))) {
                System.out.println("不完全匹配");
            }
        }

    }


    private void printIndexes(List<Item> result, List<Item> compare) {
        for (Item one : compare) {
            System.out.println(result.indexOf(one));
        }
    }

    private void printShuffled(List<Item> result, List<Item> data, List<Item> insertion) {
        for (Item item : insertion) {
            System.out.println("商品信息:" + item.getId() + "原始位置:" + data.indexOf(item) + "调整后的位置:" + result.indexOf(item));
        }
    }
}
