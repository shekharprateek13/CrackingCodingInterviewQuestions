package project.programcreek.tree;

/**
 * @author shekh
 */
public class ConvertASortedArrayToBinaryTree {

	public static TreeNode recurse(int[] inorder,int start, int end){
		if(start > end)
			return null;

		int mid = start + (end - start)/2;
		TreeNode node = new TreeNode(inorder[mid]);
		node.leftChild = recurse(inorder,start,mid - 1);
		node.rightChild = recurse(inorder,mid+1,end);
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inorder = new int[]{1,2,3,4,5,6,7,8}; 
		TreeNode root = recurse(inorder,0,inorder.length - 1);
		LevelOrderTraversal.levelOrderTraversal(root);
	}
}