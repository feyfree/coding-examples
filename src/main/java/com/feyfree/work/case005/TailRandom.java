package com.feyfree.work.case005;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TailRandom {
    public static void main(String[] args) {
        Item[] input = new Item[]{
                Item.builder().itemId(1).textId("a").build(),
                Item.builder().itemId(2).textId("b").build(),
                Item.builder().itemId(3).textId("c").build(),
                Item.builder().itemId(4).textId("d").build(),
                Item.builder().itemId(5).textId("e").build(),
                Item.builder().itemId(6).textId("f").build(),
                Item.builder().itemId(7).textId("g").build(),
                Item.builder().itemId(1).textId("h").build(),
                Item.builder().itemId(1).textId("i").build()
        };
        List<Item> data = Arrays.asList(input);
        List<Item> distinctPage = getDistinctPage(data, 10);
        if (distinctPage.size() < 10) {
            Collection<Item> remaining = CollectionUtils.removeAll(data, distinctPage);
            remaining.removeAll(distinctPage);
            // item_id : item
            Map<Integer, List<Item>> remainingMap = remaining.stream().collect(Collectors.groupingBy(Item::getItemId));
            Set<String> textSet = new HashSet<>();
            for (int i = 0; i < distinctPage.size(); i++) {
                Item item = distinctPage.get(i);
                int itemId = item.getItemId();
                List<Item> backup = remainingMap.get(itemId);
                if (backup != null && backup.size() > 0) {
                    backup.add(item);
                    Collections.shuffle(backup);
                    for (int j = 0; j < backup.size(); j++) {
                        if (!textSet.contains(backup.get(j).getTextId())) {
                            distinctPage.set(i, backup.get(j));
                            textSet.add(backup.get(j).getTextId());
                        }
                    }
                }
            }
            System.out.println(JSONObject.toJSONString(distinctPage.stream().map(Item::getTextId).collect(Collectors.toList())));
        }

    }


    private static List<Item> getDistinctPage(List<Item> source, int required) {
        int distinctInterval = 6;
        List<Item> data = new ArrayList<>();
        Set<Integer> itemSet = new HashSet<>();
        int index = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (Item item : source) {
            int product = item.getItemId();
            if (itemSet.contains(product) && indexMap.get(product) + distinctInterval > index) {
                continue;
            }
            data.add(item);
            itemSet.add(product);
            indexMap.put(product, index);
            index++;
            if (data.size() >= required) {
                break;
            }
        }
        return data;
    }


}
