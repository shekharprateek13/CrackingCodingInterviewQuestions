/**
 * 
 */
package dsalgoproblems.project.programcreek.linkedlist;

import dsalgoproblems.project.programcreek.linkedlist.MergeSortedLists.ListNode;

/**
 * @author shekh
 */
public class RemoveDuplicatesList2 {

	public static ListNode removeDuplicates(ListNode head){
		ListNode start = new ListNode(Integer.MIN_VALUE);
		start.next = head;
		ListNode node = head;
		ListNode pre = start;
		/*
		 * 1 -> 5 -> 5 -> 5 -> 2
		 * Output: 1
		 */
		while(node != null && node.next != null){
			if(node.data == node.next.data){
				int dup = node.data;
				while(node.next!= null && node.next.data == dup){
					node.next = node.next.next;
				}
				pre.next = node.next;
				node = node.next;
			}else{
				node = node.next;
				pre = pre.next;
			}
		}
		
		printList(start.next);
		return start.next;
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