package com.feyfree.basic.collection;

import java.util.ArrayList;
import java.util.List;

public class SplitList {
    public static <T> List<List<T>> splitList(List<T> list, int blockSize) {
        List<List<T>> lists = new ArrayList<>();
        if (blockSize == 1) {
            lists.add(list);
            return lists;
        }
        if (list != null && blockSize > 0) {
            int listSize = list.size();
            if (listSize <= blockSize) {
                lists.add(list);
                return lists;
            }
            int batchSize = listSize / blockSize;
            for (int i = 0; i < blockSize; i++) {
                int fromIndex = i * batchSize;
                int toIndex = fromIndex + batchSize;
                if (i != blockSize - 1) {
                    lists.add(list.subList(fromIndex, toIndex));
                } else {
                    lists.add(list.subList(fromIndex, listSize));
                }
            }
        }
        return lists;
    }
}