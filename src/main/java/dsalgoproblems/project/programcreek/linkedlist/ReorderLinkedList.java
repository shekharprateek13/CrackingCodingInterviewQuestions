package dsalgoproblems.project.programcreek.linkedlist;

/**
 * @author shekh
 */
public class ReorderLinkedList {

	public static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data = data;
		}
	}

	public static ListNode reorderList(ListNode head){
		if(head == null){
			return null;
		}

		ListNode slowRunner = head;
		ListNode fastRunner = head;

		while(fastRunner.next!=null && fastRunner.next.next!=null){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}

		ListNode secondHead = slowRunner.next;
		slowRunner.next = null;
		
		secondHead = reverseList(secondHead); 
				
		ListNode temp1 = head;
		ListNode temp2 = secondHead;
		while(temp2 != null){
			ListNode temp3 = temp1.next;
			ListNode temp4 = temp2.next;

			temp1.next = temp2;
			temp2.next = temp3;

			temp1 = temp3;
			temp2 = temp4; 
		}
		return head;
	}

	public static ListNode reverseList(ListNode head){
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
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		printList(n1);
		
		reorderList(n1);
		
		printList(n1);
		
	}
}