package com.feyfree.work.case001;

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
            return result;
        }
        return origin;
    }

    public static void main(String[] args) {
        String[] data = new String[]{"707054","567666","19404","639817","702456","670971","702099","694768","709713","666197","526837","703701","256378","709966","344350","440345","520336","657561","22163","698093","653889","706468","650934","384411","53773","16038","62571","707055","222507","702580","630700","569145","685318","526193","416077","634846","703641","645386","233932","514504","371316","259261","611209","253625","270576","566092","538947","610524","686651","10625","656642","704649","692350","477465","511431","320846","341062","660938","660206","13857","596627","518651","618160","562034","183242","427545","3613","4731","155952","488144","531060","21483","495464","498388","627286","686445","366586","589324","13831","3025","695881","537135","698852","664603","4948","10135","350668","412206","350181","332676","139252","391415","64986","539353","527682","12793"};
        List<Item> origin = new ArrayList<>();
        Map<String, Item> map = new HashMap<>();
        for (String one : data) {
            Item e = new Item(one);
            origin.add(e);
            map.put(one, e);
        }
        // 创建insertion
        String[] insertionData = new String[]{"707054","702456","702099","694768","709713","666197","703701","709966","440345","698093"};
        List<Item> insertion = new ArrayList<>();
        for (String one : insertionData
        ) {
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
