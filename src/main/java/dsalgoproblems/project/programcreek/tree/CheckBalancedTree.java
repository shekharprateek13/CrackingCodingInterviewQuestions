package dsalgoproblems.project.programcreek.tree;

/**
 * @author shekh
 *
 * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class CheckBalancedTree {
	
	public static int checkBalancedTree(TreeNode node){
		if(node == null)
			return -1;
		
		int leftHeight = checkBalancedTree(node.leftChild);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight = checkBalancedTree(node.rightChild);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(20);
		root.leftChild.rightChild = new TreeNode(10);
		root.leftChild.rightChild.rightChild = new TreeNode(100);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		System.out.println(checkBalancedTree(root)!=Integer.MIN_VALUE);
	}
}