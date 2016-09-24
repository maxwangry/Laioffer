package com.laioffer.lab;

public class InsertSortedLinkedLIst {

	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	public static ListNode insert(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		if (head == null || head.value > value) {
			newNode.next = head;
			return newNode;
		}
		ListNode prev = head;
		while (prev.next != null && prev.next.value < value) prev = prev.next;
		newNode.next = prev.next;
		prev.next = newNode;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode newHead = insert(head, 1);
		while (newHead != null) {
			System.out.println(newHead.value);
			newHead = newHead.next;
		}
	}

}
