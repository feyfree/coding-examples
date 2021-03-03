package com.feyfree.leetcode.p0025;


import com.feyfree.leetcode.commons.ListNode;

/**
 * K 个一组翻转链表
 * reverse-nodes-in-k-group
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        int len = 1;
        while (head.next != null) {
            len += 1;
            head = head.next;
        }
        ListNode pre = dummy;
        for (int i = 0; i + k <= len; i += k) {
            ListNode cur = pre.next;
            ListNode nxt = cur.next;
            for (int j = 1; j < k; j++) {
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
        }
        return dummy.next;
    }
}
