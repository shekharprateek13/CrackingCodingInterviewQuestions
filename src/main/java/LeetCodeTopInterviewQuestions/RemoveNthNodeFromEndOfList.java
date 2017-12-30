package LeetCodeTopInterviewQuestions;

public class RemoveNthNodeFromEndOfList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x; 
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		  ListNode fastRunner = head, slowRunner = head;
			
			for(int i = 0; i < n; i++) {
				fastRunner = fastRunner.next;
			}
			
			while(fastRunner != null && fastRunner.next != null){
				fastRunner = fastRunner.next;
				slowRunner = slowRunner.next;
			}
			
			if(slowRunner.next == null){
				head = null; 
			}else if(slowRunner == head && fastRunner == null){
	            head = head.next;
	        }else{
	            slowRunner.next = slowRunner.next.next;
	        }
			
	        return head;
	}

	/**
	 * 
	 * Definition for singly-linked list.
	 * 
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 *     1->2->3->4->5, and n = 2.
	 * }
	 * 
	 */

	public static void main(String[] args) {
		ListNode node = new ListNode(20);
		ListNode head = removeNthFromEnd(node, 1);
		System.out.println(head);
	}
}