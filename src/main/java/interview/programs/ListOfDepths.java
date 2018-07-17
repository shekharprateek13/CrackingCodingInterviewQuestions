/**
 * 
 */
package interview.programs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
 * (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 *
 */
public class ListOfDepths{
	
	class Node{
		int data;
		Node leftChild;
		Node rightChild;
	}
	
	static Deque<Node> QUEUE = new ArrayDeque<Node>();
	
	public static List<List<Node>> getListOfDepths(Node root){
		List<List<Node>> nodeList = new ArrayList<List<Node>>();
		List<Node> temp = null;
		QUEUE.offer(root);
		
		while(!QUEUE.isEmpty()){
//			QUEUE.
		}
		
		
		
		return null;
	}
	public static void main(String[] args) {
		List<List<Node>> nodeList = new ArrayList<List<Node>>();
		if(nodeList.get(5) == null){
			nodeList.set(5,new ArrayList<Node>());
		}
	}
}