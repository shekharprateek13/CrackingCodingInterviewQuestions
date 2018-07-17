package project.euler;

import java.util.List;

/**
 * @author shekh
 */
public class MaxPathSumFromRootToLeafBinaryTree {
	
	static int maximumSum = 0;
	static TreeNode leafNodeWithMaxSum = null;
	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data){
			this.data = data;
		}
	}
	
	public static boolean printMaxPath(TreeNode root,TreeNode leafNode,List<TreeNode> list){
		if(root == null){
			return false;
		}
		
		if(root.data == leafNode.data || printMaxPath(root.left,leafNode,list) || printMaxPath(root.right,leafNode,list)){
			System.out.println(root.data);
			return true;
		}
		return false;
	}
	
	public static void findMaxPathSum(TreeNode root,int currentSum){
		if(root == null){
			return;
		}
		
		currentSum = currentSum + root.data;
		
		if(MaxPathSumFromRootToLeafBinaryTree.maximumSum < currentSum){
			MaxPathSumFromRootToLeafBinaryTree.maximumSum = currentSum;
			if(root.left == null && root.right == null){
				MaxPathSumFromRootToLeafBinaryTree.leafNodeWithMaxSum = root;
			}
		}
		
		findMaxPathSum(root.left, currentSum);
		findMaxPathSum(root.right, currentSum);
	}

	public static void main(String[] args) {
		
	}
}