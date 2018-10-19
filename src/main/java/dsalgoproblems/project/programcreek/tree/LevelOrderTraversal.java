/**
 * 
 */
package dsalgoproblems.project.programcreek.tree;

import java.util.LinkedList;

/**
 * @author shekh
 */
public class LevelOrderTraversal {
	
	public static void levelOrderTraversal(TreeNode root){
		if(root == null){
			return;
		}
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node+" ");
			if(node.leftChild != null){
				queue.add(node.leftChild);
			}
			
			if(node.rightChild != null){
				queue.add(node.rightChild);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.leftChild.leftChild = new TreeNode(10);
		root.leftChild.leftChild.rightChild = new TreeNode(11);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		root.rightChild.rightChild = new TreeNode(7);
		root.rightChild.rightChild.leftChild = new TreeNode(8);
		root.rightChild.rightChild.rightChild = new TreeNode(9);
		levelOrderTraversal(root);
		
		/*
		 *         1
   		 *	     /   \
  		 *	    2     3
 		 *	   / \   / \
		 *    4   5 6   7
		 *	 / \	   / \
		 *	10 11	  8   9
		 */		
	}
}