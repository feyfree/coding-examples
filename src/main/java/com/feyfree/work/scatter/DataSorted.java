package com.feyfree.work.scatter;


import java.util.*;

public class DataSorted {
    static double u = 0.5;

    public static void main(String[] args) {
        List<Item> ls = new ArrayList<>();
        ls.add(new Item("1", "1011326", 11.0));
        ls.add(new Item("2", "1011326", 11.0));
        ls.add(new Item("3", "1011326", 11.1));
        ls.add(new Item("4", "991664", 11.0));
        ls.add(new Item("4", "1011741", 11.0));
        ls.add(new Item("4", "1004101", 11.0));
        ls.add(new Item("4", "B", 11.0));
        ls.sort((o1, o2) -> {
            double diff = o1.getScore() - o2.getScore();
            if (diff > 0) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(ls);
//        System.out.println(scoreScatter(ls));
//        System.out.println(bucketScatter(ls));
        windowsScatter(ls, null);
        System.out.println(ls);
    }

    /**
     * 通过设置滑动窗口，对窗口内元素一定程度打散
     *
     * @param numbers
     * @param length
     * @return
     * @author guoyanchao@eqxiu.com
     */
    public static List<Item> windowsScatter(List<Item> numbers, Integer length) {
//        List<Item> ls = new ArrayList<>();
        if (length == null || length > groupByType(numbers).size()) {
            length = groupByType(numbers).size();
        }
        for (int i = 0; i < numbers.size() - length; i++) {
            List<Item> subls = numbers.subList(i, i + length);
            List<String> keys = new ArrayList<>();
            int j = length + i;
            for (int m = 0; m < length; m++) {
                Item item = subls.get(m);
                if (keys.contains(item.getType())) {
                    numbers.set(i + m, numbers.get(j));
                    numbers.set(j, item);
                    keys.add(item.getType());
                    j += 1;
                } else {
                    keys.add(item.getType());
                }
            }
        }
        return numbers;
    }

    /**
     * 通过分桶对全局数据打散
     *
     * @param numbers
     * @return
     * @author guoyanchao@eqxiu.com
     */
    public static List<Item> bucketScatter(List<Item> numbers) {
        Map<String, List<Item>> map = groupByType(numbers);
        List<Item> ls = new ArrayList<>();
        int maxSize = 0;
        for (String key : map.keySet()) {
            if (map.get(key).size() > maxSize) {
                maxSize = map.get(key).size();
            }
        }
        for (int i = 0; i < maxSize; i++) {
            List<Item> tmp = new ArrayList<>();
            for (String k : map.keySet()) {
                List<Item> gls = map.get(k);
                if (i < gls.size()) {
                    tmp.add(gls.get(i));
                }
            }
            Collections.sort(tmp, new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    Double diff = o1.getScore() - o2.getScore();
                    if (diff > 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
            ls.addAll(tmp);
        }
        return ls;
    }

    /**
     * 通过重新计算得分，使用新的排名进行打散
     *
     * @param numbers
     * @return
     * @author guoyanchao@eqxiu.com
     */
    public static List<Item> scoreScatter(List<Item> numbers) {
        List<Item> ls = new ArrayList<>();
        Map<String, List<Item>> map = groupByType(numbers);
//        System.out.println(map);
        for (String key : map.keySet()) {
            numbers = map.get(key);
            numbers = cumulativeSum(numbers);
            for (int i = 0; i < numbers.size(); i++) {
                Item item = numbers.get(i);
                if (i < numbers.size() - 1) {
                    item.setNewScore(Math.pow(Math.pow(item.getNewScore(), 1 / u) - Math.pow(numbers.get(i + 1).getNewScore(), 1 / u), u));
                } else {
                    item.setNewScore(Math.pow(Math.pow(item.getNewScore(), 1 / u), u));
                }
            }
            ls.addAll(numbers);
        }
        Collections.sort(ls, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                Double diff = o1.getNewScore() - o2.getNewScore();
                if (diff > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return ls;
    }

    public static Map<String, List<Item>> groupByType(List<Item> numbers) {
        Map<String, List<Item>> map = new HashMap<>();

        for (Item item : numbers) {
            if (map.containsKey(item.getType())) {
                map.get(item.getType()).add(item);
            } else {
                List<Item> ls = new ArrayList<>();
                ls.add(item);
                map.put(item.getType(), ls);
            }
        }
        return map;
    }

    private static List<Item> cumulativeSum(List<Item> numbers) {

        double sum = 0;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            Item item = numbers.get(i);
            sum += item.getScore(); // find sum
            item.setNewScore(sum);
//            numbers.set(i, item); // replace
        }

        return numbers;
    }

}