package com.feyfree.leetcode.p0341.common;


import com.feyfree.leetcode.p0341.NestedInteger;

import java.util.Iterator;
import java.util.List;

/**
 * 常规做法也是推荐的, 符合迭代器的设计理念
 *
 * @author leilei
 */
public class NestedIterator implements Iterator<Integer> {
    private final List<NestedInteger> nestedList;
    private final int size;
    private int cursor = 0;
    private NestedIterator iterator = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.size = nestedList.size();
    }

    @Override
    public Integer next() {
        NestedInteger current = nestedList.get(cursor);
        if (current.isInteger()) {
            cursor++;
            return current.getInteger();
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        while (cursor < size) {
            NestedInteger current = nestedList.get(cursor);
            if (current.isInteger()) {
                return true;
            } else {
                if (iterator == null) {
                    iterator = new NestedIterator(current.getList());
                }
                if (iterator.hasNext()) {
                    return true;
                } else {
                    iterator = null;
                    cursor++;
                }
            }
        }
        return false;
    }
}