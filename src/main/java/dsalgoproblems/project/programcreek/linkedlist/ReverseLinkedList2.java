package dsalgoproblems.project.programcreek.linkedlist;

import dsalgoproblems.project.programcreek.linkedlist.MergeSortedLists.ListNode;

/**
 * @author shekh
 */
public class ReverseLinkedList2 {

	/*
	 * Input: 1 -> 2 -> 3 -> 4 -> 5
	 * Start = 2
	 * End = 4
	 * 1 -> 2 <- 3 <- 4  5
	 * Output:
	 * 1 -> 4 -> 3 -> 2 -> 5
	 */
	public static ListNode reverseLinkedList(ListNode head, int start, int end){
		int count = 1;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode curr = head;

		while(count < start && curr != null){
			curr = curr.next;
			pre = pre.next;
			count++;
		}

		ListNode pre1 = curr;
		curr = curr.next;
		while(count < end && curr != null){
			ListNode temp = curr.next;
			curr.next = pre1;
			pre1 = curr;
			curr = temp;
			count++;
		}

		ListNode endNode = pre.next;
		pre.next = pre1;
		endNode.next = curr;


		return head;
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
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		printList(n1);
		ListNode newHead = reverseLinkedList(n1,2,4);
		printList(newHead);

	}

}
