package dsalgoproblems.project.programcreek.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shekh
 */
public class LRUCache {

	static class ListNode{
		int data;
		ListNode next;
		ListNode prev;
		
		ListNode(){}
		
		ListNode(int data){
			this.data = data;
		}
	}

	private static Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
	private static ListNode start = null;
	private static ListNode end = null;
	private static int capacity = 10;
	private static int currentSize = 0;

	public static int get(int key){
		if(map.containsKey(key)){
			ListNode temp = map.get(key);
			ListNode prev = temp.prev;
			ListNode next = temp.next;
			prev.next = next;
			if(next!=null){
				next.prev = prev;
			}
			temp.prev = null;
			temp.next = start;
			start.prev = temp;
			start = temp;
			return temp.data;
		}
		return -1;
	}

	public static void set(int key, int value){
		if(map.containsKey(key)){
			ListNode temp = map.get(key);
			temp.data = value;

			ListNode prev = temp.prev;
			ListNode next = temp.next;
			prev.next = next;
			if(next!=null){
				next.prev = prev;
			}
			temp.prev = null;
			temp.next = start;
			start.prev = temp;
			start = temp;
		}else{
			if(currentSize == capacity){
				ListNode temp = start;
				while(temp.next != null){
					temp = temp.next;
				}
				ListNode prev = temp.prev;
				prev.next = null;
				temp.prev = null;
				currentSize--;
			}
			ListNode newNode = new ListNode();
			newNode.data = value;
			newNode.next = start;
			if(start!=null){
				start.prev = newNode;
			}
			start = newNode;
			currentSize++;
			map.put(key, newNode);
		}
	}

	public static void displayNodes(){
		ListNode temp = start;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LRUCache.set((int)Math.pow(10,2),10);
		LRUCache.set((int)Math.pow(20,2),20);
		LRUCache.set((int)Math.pow(30,2),30);
		LRUCache.set((int)Math.pow(40,2),40);
		LRUCache.set((int)Math.pow(50,2),50);
		displayNodes();
		System.out.println("Value: "+LRUCache.get(400));
		displayNodes();
		System.out.println("--------------------");
		LRUCache.set((int)Math.pow(2,2),2);
		LRUCache.set((int)Math.pow(3,2),3);
		LRUCache.set((int)Math.pow(4,2),4);
		LRUCache.set((int)Math.pow(5,2),5);
		LRUCache.set((int)Math.pow(6,2),6);
		LRUCache.set((int)Math.pow(7,2),7);
		displayNodes();
	}
}