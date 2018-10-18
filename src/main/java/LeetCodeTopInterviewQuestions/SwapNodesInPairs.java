package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 */
public class SwapNodesInPairs {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void displayNodes(ListNode node){
		System.out.println("\n----------------------------\n");
		while(node!=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
	}

	public static ListNode swapPairs(ListNode head){
		if(head.next == null)return head;
		
		ListNode first = head;
		ListNode second = head.next;
		ListNode newHead = second;
		ListNode temp = null;
		
		while(second!=null){
			first.next = second.next;
			second.next = first;
			
			temp = first;
			first = second;
			second = temp;
			
			if(second.next != null && second.next.next != null){
				temp = second;
				first = first.next.next;
				second = second.next.next;
				temp.next = second;
			}else if((second.next != null && second.next.next == null) || (second.next == null)){
				break;
			}
		}
		return newHead;
	}

	public static void main(String[] args){
		ListNode head = new ListNode(2);
		ListNode node = new ListNode(1);
		head.next = node;
		node.next = new ListNode(4);
		node = node.next;
		/*node.next = new ListNode(3);
		node = node.next;*/
		System.out.println("Original Set of Nodes!!!");
		displayNodes(head);
		node = swapPairs(head);
		System.out.println("New Set of Nodes!!!");
		displayNodes(node);
	}
}