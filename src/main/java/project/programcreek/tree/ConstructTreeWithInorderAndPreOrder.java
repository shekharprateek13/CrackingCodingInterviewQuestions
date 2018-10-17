package project.programcreek.tree;

/**
 * @author shekh
 */
public class ConstructTreeWithInorderAndPreOrder {
	
	/*
	 * in-order:   4 2 5 (1) 6 7 3 8
	 * pre-order: (1) 2 4 5  3 7 6 8
	 */
	public static TreeNode constructTree(int [] inorder, int[] preorder, int preStart, int preEnd, int inStart, int inEnd){
		if(preStart > preEnd || inStart > inEnd){
			return null;
		}
		
		int val = preorder[preStart];
		TreeNode node = new TreeNode(val);
		int breakPoint = 0;
		for(int i = inStart; i < inorder.length; i++){
			if(val == inorder[i]){
				breakPoint = i;
				break;
			}
		}
		int length = breakPoint - inStart;
		
		node.leftChild = constructTree(inorder,preorder,preStart + 1,preStart + length,inStart,breakPoint - 1);
		node.rightChild = constructTree(inorder,preorder,preStart + 1 + length,preEnd,breakPoint + 1,inEnd);
		
		return node;
	}
	
	public static void main(String[] args) {
		int[] inorder = new int[]{4,2,5,1,6,7,3,8};
		int[] preorder = new int[]{1,2,4,5,3,7,6,8};
		
		TreeNode root = constructTree(inorder,preorder,0,preorder.length - 1,0,inorder.length - 1);
		LevelOrderTraversal.levelOrderTraversal(root);
	}
}