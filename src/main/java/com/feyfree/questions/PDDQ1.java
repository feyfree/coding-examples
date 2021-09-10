package com.feyfree.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个数组，其中数组中的每个值与相邻元素之间的差值的绝对值是m，现在给你一个目标值k，找到数组中所有等于k的元素的索引，使用集合返回。
 * 遍历的元素越少越好，无序
 * List fun(List<Integer> list,int m,int k)
 * 就比如[1,2,3,2,1,0,-1,0,1] m=1 k=3 返回[2] ，k一定是数组中的某个值
 * <p>
 * 作者：清香的茉莉
 * 链接：https://leetcode-cn.com/circle/discuss/AZEIz6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class PDDQ1 {

    private List<Integer> getK(int[] nums, int m, int k) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        int length = nums.length;
        while (index < length) {
            int current = nums[index];
            int diff = Math.abs(k - current);
            if (diff == 0) {
                result.add(index);
                index += 2;
            } else {
                int step = diff / m;
                index += step;
            }
        }
        return result;
    }
}
