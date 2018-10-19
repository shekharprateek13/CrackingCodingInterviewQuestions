package dsalgoproblems.project.programcreek.linkedlist;

import dsalgoproblems.project.programcreek.linkedlist.MergeSortedLists.ListNode;

/**
 * @author shekh
 */
public class RemoveDuplicatesList1 {

	public static ListNode removeDuplicates(ListNode head){
		ListNode pre = head;
		ListNode node = head.next;
		/*
		 * 1 -> 5 -> 5 -> 5
		 * Output: 1 -> 5
		 */
		while(node != null){
			if(pre.data == node.data){
				pre.next = node.next;
				node.next = null;
				node = pre.next;
			}else{
				node = node.next;
				pre = pre.next;
			}
		}
		
		printList(head);
		return null;
	}

	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.data+"->");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		removeDuplicates(n1);
	}
}