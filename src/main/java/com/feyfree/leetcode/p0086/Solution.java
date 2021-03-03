package com.feyfree.leetcode.p0086;

import com.feyfree.leetcode.commons.ListNode;

/**
 * p86 solution
 * <p>
 * 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode();
        ListNode pl = dummyL;
        ListNode dummyR = new ListNode();
        ListNode pr = dummyR;
        while (head != null) {
            boolean flag = head.val < x;
            if (flag) {
                pl.next = head;
                pl = pl.next;
            } else {
                pr.next = head;
                pr = pr.next;
            }
            head = head.next;
        }
        pr.next = null;
        pl.next = dummyR.next;
        return dummyL.next;
    }
}
