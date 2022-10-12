package com.feyfree.work.case005;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private List<Text> getInput() {
        List<Text> input = new ArrayList<>();
        int textId = 0;
        for (int i = 0; i < 20; i++) {

            int textNum = 4;
            for (int j = 0; j < textNum; j++) {
                input.add(Text.builder()
                        .itemId(String.valueOf(i))
                        .textId(String.valueOf(textId++))
                        .build());
            }
        }
        return input;
    }


    private List<Text> getInsertion(List<Text> input) {
        return input.stream().filter(o -> o.getItemId().equals("1") || o.getItemId().equals("3")).collect(Collectors.toList());
    }


    private void process() {
        List<Text> input = getInput();
        Collections.shuffle(input);
        System.out.println(JSONObject.toJSONString(input));
        List<Text> insertion = getInsertion(input);
        List<Text> result = insertionShuffle(input, insertion);
        System.out.println(JSONObject.toJSONString(result));
    }

    /**
     * 按照defaultShuffler 先写一下
     *
     * @param texts
     * @return
     */
    private List<Text> shuffleTextByItem(List<Text> texts) {
        List<Text> res = new ArrayList<>();
        int sameCatItemNum = 0;
        int lastCate = -1;
        while (texts.size() > 0) {
            int flag = getCat(texts.get(0));

            if (lastCate == -1 || (flag != lastCate)) {
                //无品类或品牌与之前不同的情况，不需要shuffle
                res.add(texts.get(0));
                texts.remove(0);
                lastCate = flag;
                sameCatItemNum = 1;
            } else {
                sameCatItemNum++;
                if (sameCatItemNum > 2) {
                    //连续三个相同类目, 查找待交换的shuffle对象
                    boolean bFind = false;
                    int j = 1;
                    for (; j < texts.size(); j++) {
                        if (lastCate != getCat(texts.get(j))) {
                            bFind = true;
                            break;
                        }
                    }
                    if (bFind) {
                        //找到待shuffle的对象，则进行shuffle,
                        res.add(texts.get(j));
                        lastCate = getCat(texts.get(j));
                        sameCatItemNum = 1;
                        texts.remove(j);
                    } else {
                        //没找到shuffle对象，则后面都是相同品类，也无需再shuffle了。
                        res.addAll(texts);
                        texts.clear();
                    }

                } else {
                    res.add(texts.get(0));
                    texts.remove(0);
                }
            }
        }
        return res;
    }


    private int getCat(Text item) {
        if (item.getItemId() == null) {
            return -1;
        }
        return Integer.parseInt(item.getItemId());
    }

    private List<Text> insertionShuffle(List<Text> origin, List<Text> insertions) {
        Set<String> insertionSet = insertions.stream().map(Text::getTextId).collect(Collectors.toSet());
        insertions = origin.stream().filter(o -> insertionSet.contains(o.getTextId())).collect(Collectors.toList());
        insertions = shuffleTextByItem(insertions);
        List<Text> normals = origin.stream().filter(o -> !insertionSet.contains(o.getTextId())).collect(Collectors.toList());
        List<Text> result = new ArrayList<>(origin.size());
        // 间隔一定大于1 TODO 可以调整到 1
        int interval = 1;
        // 分桶
        // calculate relative index
        Text[] container = new Text[insertions.size() * 2];
        int bucketIndex = 0;
        int prev = -1;
        for (int i = 0; i < origin.size(); i++) {
            Text item = origin.get(i);
            if (insertionSet.contains(item.getTextId())) {
                container[bucketIndex * interval + i % interval] = item;
                insertionSet.remove(item.getTextId());
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.process();
    }
}
