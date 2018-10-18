package project.programcreek.linkedlist;

/**
 * @author shekh
 */
public class CopyListWithArbitraryPointers {
	static class ListNode{
		int data;
		ListNode next;
		ListNode randomPointer;

		ListNode(int data){
			this.data = data;
		}
	}

	public static void copyList(ListNode head){
		ListNode temp = head;
		ListNode newHead = null;
		
		while(temp != null){
			ListNode newNode = new ListNode(temp.data);
			newNode.next = temp.next;
			temp.next = newNode;
			temp = newNode.next;
		}

		ListNode temp1 = head;
		ListNode temp2 = head.next;
		newHead = head.next;

		while(temp1 != null){
			if(temp1.randomPointer!=null){
				temp2.randomPointer = temp1.randomPointer.next;
			}
			
			if(temp1.next != null){
				temp1 = temp1.next.next;
			}
			
			if(temp2.next != null){
				temp2 = temp2.next.next;
			}
		}

		temp1 = head;
		temp2 = newHead;

		while(temp1 != null){
			temp1.next = temp1.next.next;
			temp2.next = temp2.next.next;
			temp1 = temp1.next;
			temp2 = temp1.next;
		}

		printList(head);
		System.out.println();
		printList(newHead); 
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
		copyList(n1);
	}
}