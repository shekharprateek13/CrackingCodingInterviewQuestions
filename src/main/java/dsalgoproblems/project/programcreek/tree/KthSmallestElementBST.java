package dsalgoproblems.project.programcreek.tree;

/**
 * @author shekh
 */
public class KthSmallestElementBST {
	
	static int currentCount = 0;
	
	public static void resetCurrentCount(){
		KthSmallestElementBST.currentCount = 0;
	}

	public static void getKthSmallestElement(TreeNode root, int k){
		if(root == null)
			return;
		
		getKthSmallestElement(root.leftChild, k);
		
		currentCount++;
		if(currentCount == k){
			System.out.println(root);
		}
		
		getKthSmallestElement(root.rightChild, k);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(27);
		root.leftChild = new TreeNode(14);
		root.leftChild.leftChild = new TreeNode(10);
		root.leftChild.rightChild = new TreeNode(19);

		root.rightChild = new TreeNode(35);
		root.rightChild.leftChild = new TreeNode(31);
		root.rightChild.rightChild = new TreeNode(42);
		getKthSmallestElement(root,6);
		
		/*
		 *         27
   		 *	     /   \
  		 *	    14   35
 		 *	   / \   / \
		 *    10 19 31 42
		 */
		resetCurrentCount();
		getKthSmallestElement(root,5);
	}
}