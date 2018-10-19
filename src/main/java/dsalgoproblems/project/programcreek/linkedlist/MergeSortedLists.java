package dsalgoproblems.project.programcreek.linkedlist;

/**
 * @author shekh
 */
public class MergeSortedLists {

	static class ListNode{
		int data;
		ListNode next;

		ListNode(int data){
			this.data = data;
		}
	}

	public static ListNode mergeLists(ListNode l1, ListNode l2){
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode temp = head;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		
		while(temp1 != null && temp2 != null){
			if(temp1.data < temp2.data){
				temp.next = temp1;
				temp1 = temp1.next;
			}else{
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		head = head.next;
		return head;
	}

	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.data+"->");
			n = n.next;
		}
	}


	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(10);
		ListNode n4 = new ListNode(15);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println("\nN1: ");
		printList(n1);
		
		ListNode n11 = new ListNode(3);
		ListNode n22 = new ListNode(4);
		ListNode n33 = new ListNode(5);
		ListNode n44 = new ListNode(40);
		n11.next = n22;
		n22.next = n33;
		n33.next = n44;
		System.out.println("\nN11: ");
		printList(n11);

		ListNode newHead = mergeLists(n1,n11);
		printList(newHead);
	}
}