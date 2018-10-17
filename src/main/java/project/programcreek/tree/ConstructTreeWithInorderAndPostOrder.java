package project.programcreek.tree;

/**
 * @author shekh
 */
public class ConstructTreeWithInorderAndPostOrder {
	
	/*
	 * in-order:   4 2 5  (1)  6 7 3 8
	 * post-order: 4 5 2  6 7 8 3  (1)
	 */
	public static TreeNode constructTree(int [] inorder, int[] postorder, int postStart, int postEnd, int inStart, int inEnd){
		if(postStart > postEnd || inStart > inEnd){
			return null;
		}
		
		int val = postorder[postEnd];
		TreeNode node = new TreeNode(val);
		int breakPoint = 0;
		for(int i = inStart; i < inorder.length; i++ ){
			if(val == inorder[i]){
				breakPoint = i;
				break;
			}
		}
		int length = breakPoint - inStart;
		
		node.leftChild = constructTree(inorder,postorder,postStart,postStart + length - 1,inStart,breakPoint - 1);
		node.rightChild = constructTree(inorder,postorder,postStart + length,postEnd - 1,breakPoint + 1,inEnd);
		return node;
	}
	
	public static void main(String[] args){
		int[] inorder = new int[]{4,2,5,1,6,7,3,8};
		int[] postorder = new int[]{4,5,2,6,7,8,3,1};
		
		TreeNode root = constructTree(inorder,postorder,0,postorder.length - 1,0,inorder.length - 1);
		LevelOrderTraversal.levelOrderTraversal(root);
	}
}