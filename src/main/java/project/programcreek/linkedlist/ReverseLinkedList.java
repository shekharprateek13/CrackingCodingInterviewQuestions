package project.programcreek.linkedlist;

import project.programcreek.linkedlist.MergeSortedLists.ListNode;

public class ReverseLinkedList {

	public static ListNode reverseLinkedList(ListNode head){
		ListNode pre = head;
		ListNode curr = head.next;
		while(curr != null){
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
		head.next = null;
		return pre;
	}

	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.data+"->");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(10);
		ListNode n4 = new ListNode(15);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		printList(n1);
		ListNode newHead = reverseLinkedList(n1);
		printList(newHead);
	}
}