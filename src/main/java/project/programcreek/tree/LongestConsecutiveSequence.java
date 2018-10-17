package project.programcreek.tree;

import java.util.LinkedList;

/**
 * @author shekh.........................
 */
public class LongestConsecutiveSequence {

	static LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	static LinkedList<Integer> sizeQueue = new LinkedList<Integer>();

	public static int getLongestConsecutiveSequence(TreeNode root) {
		if(root == null)
			return 0;

		queue.offer(root);
		sizeQueue.add(1);
		int max = 1;
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int size = sizeQueue.poll();
			if(node.leftChild!= null){
				int leftSize = size;
				if(node.leftChild.data - node.data == 1){
					leftSize++;
					max = Math.max(max,leftSize);
				}else{
					leftSize = 1;
				}
				queue.offer(node.leftChild);
				sizeQueue.offer(leftSize);
			}

			if(node.rightChild!= null){
				int rightSize = size;
				if(node.rightChild.data - node.data == 1){
					rightSize++;
					max = Math.max(max,rightSize);
				}else{
					rightSize = 1;
				}
				queue.offer(node.rightChild);
				sizeQueue.offer(rightSize);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(3);
		root.rightChild = new TreeNode(4);
		root.rightChild.leftChild = new TreeNode(5);
		root.rightChild.rightChild = new TreeNode(6);
		root.rightChild.rightChild.leftChild = new TreeNode(7);
		System.out.println(getLongestConsecutiveSequence(root));
		/*
		 *         
		 *	     /   \
		 *	    14   35
		 *	   / \   / \
		 *    10 19 31 42
		 */
	}
}