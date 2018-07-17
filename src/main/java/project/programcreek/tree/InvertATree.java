package project.programcreek.tree;

/**
 * @author shekh
 */
public class InvertATree {
	
	public static void invertBinaryTree(TreeNode root){
		if(root == null)
			return;
		
		invertBinaryTree(root.leftChild);
		invertBinaryTree(root.rightChild);
		
		if(root.leftChild!=null && root.rightChild!=null){
			TreeNode temp = root.leftChild;
			root.leftChild = root.rightChild;
			root.rightChild = temp;
		}
	}

	public static void main(String[] args){
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
		System.out.println("\nOld Tree:");
		LevelOrderTraversal.levelOrderTraversal(root);
		invertBinaryTree(root);
		System.out.println("\nNew Tree:");
		LevelOrderTraversal.levelOrderTraversal(root);
		/*
		 * Original Tree
		 *         1					
   		 *	     /   \	
  		 *	    2     3
 		 *	   / \   / \				
		 *    4   5 6   7
		 *	 / \	   / \
		 *	10 11	  8   9
		 */
		
		/*
		 * New Tree
		 *         1					
   		 *	     /   \	
  		 *	    3     2
 		 *	   / \   / \				
		 *    7   6 5   4
		 *	 / \	   / \
		 *	9   8	  11 10
		 */
		
	}
}