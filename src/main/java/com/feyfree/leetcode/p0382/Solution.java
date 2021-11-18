package com.feyfree.leetcode.p0382;

import com.feyfree.leetcode.commons.ListNode;

import java.util.Random;


/**
 * https://leetcode-cn.com/problems/linked-list-random-node/
 * 382. 链表随机节点
 * <p>
 * 蓄水池采样法
 *
 * @author leilei
 */
class Solution {

    private final ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int result = 0;
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            if (new Random().nextInt() % i == 0) {
                result = cur.val;
            }
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);
        System.out.println(solution.getRandom());
    }
}
