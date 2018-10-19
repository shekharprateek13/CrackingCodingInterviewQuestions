package dsalgoproblems.project.programcreek.tree;

/**
 * @author shekh
 */
public class ValidateBinarySearchTree {
	
	public static boolean validateBinaryTree(TreeNode root, int min, int max){
		if(root == null)
			return true;
		
		if(root.data < min || root.data > max){
			return false;
		}
		
		if(!validateBinaryTree(root.leftChild, min, root.data) || ! validateBinaryTree(root.rightChild, root.data, max)){
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.leftChild = new TreeNode(10);
		root.leftChild.leftChild = new TreeNode(3);
		root.leftChild.rightChild = new TreeNode(15);
		root.rightChild = new TreeNode(100);
		root.rightChild.leftChild = new TreeNode(25);
		root.rightChild.rightChild = new TreeNode(360);
		System.out.println(validateBinaryTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		/*
		 *            20
		 *	        /    \
		 *	      10     30
		 *	     /  \   /  \
		 *      3   15 25  36
		 */
	}
}