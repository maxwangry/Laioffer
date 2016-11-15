package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/26.
 */
public class ReversePairs {

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public static ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseInPairs(head.next.next);
        ListNode curr = head;
        ListNode next = head.next;
        curr.next = newHead;
        next.next = curr;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode result = reverseInPairs(head);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
