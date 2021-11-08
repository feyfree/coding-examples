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
        Set<String> insertionSet = insertions.stream().map(Item::getId).collect(Collectors.toSet());
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
        String[] data = new String[]{"696297", "286734", "351876", "388106", "577086", "660206", "349839", "647158", "221877", "704523", "701814", "37159", "419449", "432699", "628630", "689711", "648304", "602270", "423649", "562034", "7793", "8159", "17398", "664603", "711272", "707159", "22163", "609511", "317278", "708664", "708119", "610252", "292884", "681278", "610524", "598792", "555263", "7648", "604252", "678528", "470841", "693820", "25293", "8820", "476656", "605571", "682163", "684990", "648680", "338581", "577129", "701166", "371481", "691127", "608011", "714665", "705196", "577082", "280954", "667789", "488065", "25258", "644659", "713927", "105617", "493913", "362123", "90872", "481448", "634973", "543779", "438259", "7043", "681788", "288098", "698916", "680461", "613462", "710490", "263365", "696296", "440345", "646508", "494697", "577775", "6052", "702529", "577084", "679721", "666565", "18160", "596624", "702532", "454289", "396305", "698092", "608610", "629156", "270576", "16065", "408706"};
        List<Item> origin = new ArrayList<>();
        Map<String, Item> map = new HashMap<>();
        for (String one : data) {
            Item e = new Item(one);
            origin.add(e);
            map.put(one, e);
        }
        // 创建insertion
        String[] insertionData = new String[]{"696297", "286734", "704523", "701814", "689711", "711272", "707159", "708664", "708119", "605571"};
        List<Item> insertion = new ArrayList<>();
        for (String one : insertionData) {
            insertion.add(map.get(one));
        }

        Insertion f = new Insertion();
        List<Item> result = f.afterInsertion2(insertion, origin, 50);
        // find interval
        f.printIndexes(result, insertion);
        // find missing
        f.findMissing(result, origin);
        // find compare
        f.printShuffled(result, origin, insertion);

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
