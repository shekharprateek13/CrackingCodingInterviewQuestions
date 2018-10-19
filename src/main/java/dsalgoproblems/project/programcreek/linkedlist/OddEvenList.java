package dsalgoproblems.project.programcreek.linkedlist;

/**
 * @author shekh
 */
public class OddEvenList {

	static class ListNode{
		int data;
		ListNode next;

		ListNode(int data){
			this.data = data;
		}
	}

	public static ListNode getOddEvenList(ListNode head){
		ListNode oddHead = head;
		ListNode oddNode = oddHead;
		ListNode evenHead = head.next;
		ListNode evenNode = evenHead;

		while(oddNode != null && evenNode != null) {
			oddNode.next = evenNode.next;
			oddNode = oddNode.next;

			if(oddNode != null) {
				evenNode.next = oddNode.next;
				evenNode = evenNode.next;
			}
		}
		
		oddNode = oddHead;
		while(oddNode.next != null){
			oddNode = oddNode.next;
		}
		
		oddNode.next = evenHead;
		printList(oddHead);
		return oddHead;
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
		System.out.println("\nN1: ");
		getOddEvenList(n1);
	}
}