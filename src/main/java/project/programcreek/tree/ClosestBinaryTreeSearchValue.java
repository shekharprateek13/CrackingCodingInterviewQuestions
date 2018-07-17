package project.programcreek.tree;

/**
 * @author shekh
 */
public class ClosestBinaryTreeSearchValue {

	static int min_value = Integer.MAX_VALUE;
	static TreeNode minNode = null;
	public static void closestBinaryTreeSearchValue(TreeNode root,int target){
		if(root == null)
			return;
		
		
		if(min_value > Math.abs(root.data - target)){
			min_value = Math.abs(root.data - target);
			minNode = root;
		}
		
		if(target > root.data){
			closestBinaryTreeSearchValue(root.rightChild, target);
		}else{
			closestBinaryTreeSearchValue(root.leftChild, target);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(5);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(7);
		root.rightChild = new TreeNode(30);
		closestBinaryTreeSearchValue(root, 125);
		System.out.println("Min Value: "+min_value);
		System.out.println("Min Node: "+minNode);

	}

}
