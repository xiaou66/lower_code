package com.xiaou.leetcode;

import org.junit.Test;

/**
 * @url https://leetcode-cn.com/problems/add-two-numbers/
 * @author xiaou
 */
public class T2 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    @Test
    public void run () {
        ListNode l1 = new ListNode(2);

        ListNode l1Cur = l1;
        l1Cur.next = new ListNode(4);
        l1Cur = l1Cur.next;
        l1Cur.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l2Cur = l2;
        l2Cur.next = new ListNode(6);
        l2Cur = l2Cur.next;
        l2Cur.next = new ListNode(4);
        ListNode res = addTwoNumbers2(l1, l2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p1 = l1,p2 = l2,curr = node;
        int carry = 0;
        while(p1 != null || p2 != null){
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum /10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return node.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 创建结果的头节点
        ListNode res = new ListNode(0);
        // 创建结果的浮标
        ListNode cursor = res;
        // 上一轮 十位的数字
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            // 当前次计算的结果集
            int sum = 0;
            // 计算当前 l1 节点值, 并且下移
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 计算当前 l2 节点值, 并且下移
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            // 加上上一次的超过10的进位
            sum += carry;
            // 去除十位的数字
            cursor.next = new ListNode(sum % 10);
            // 下移
            cursor = cursor.next;
            // 获取十位数字
            carry = sum / 10;
        }
        // 返回结果链表
        return res.next;
    }
}
