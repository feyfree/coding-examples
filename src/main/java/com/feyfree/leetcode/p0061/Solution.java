package com.feyfree.leetcode.p0061;

import com.feyfree.leetcode.commons.ListNode;

/**
 * p61
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * <p>
 * 示例1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmp = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = head;
        tmp.next = head;
        int len = 0;
        while (tmp.next != null) {
            len++;
            tmp = tmp.next;
        }
        if (len == 0) {
            return null;
        }
        // 计算偏移量
        int offset = len - k % len;
        while (offset > 0) {
            dummy = dummy.next;
            offset--;
        }
        if (dummy.next == null) {
            return head;
        }
        ListNode newHead = dummy.next;
        dummy.next = null;
        ListNode tmp2 = newHead;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        tmp2.next = head;
        return newHead;
    }
}
