package dsalgoproblems.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shekh
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
 *  Assume a BST is defined as follows:
 *  The left subtree of a node contains only nodes with keys less than the node's key.
 *  The right subtree of a node contains only nodes with keys greater than the node's key.
 *  Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

	static List<TreeNode> list = new LinkedList<TreeNode>();

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x; 
		}
	}
	
	private static void inOrder(TreeNode node) {
		if(node == null) {
			return;
		}

		inOrder(node.left);
		list.add(node);
		inOrder(node.right);
	}

	public static boolean isValidBSTUsingExtraSpace(TreeNode root) {
		boolean isValidBST = true;
		inOrder(root);
		for(int i = 1; i < list.size(); i++){
			if(list.get(i-1).val >= list.get(i).val){
				isValidBST = false;
				break;
			}
		}
		return isValidBST;
	}
	
	public static boolean isValidBSTWithoutExtraSpace(TreeNode root) {
		boolean isValidBST = true;
		if(root.left == null && root.right == null){
			return true;
		}
		
		if(root.left!= null){
			if(root.left.val > root.val){
				return false;
			}
		}
		
		if(root.right!= null){
			if(root.right.val < root.val){
				return false;
			}
		}
		
		if(root.left!= null){
			isValidBST = isValidBSTWithoutExtraSpace(root.left);
		}
		
		if(root.right!=null && isValidBST){
			isValidBST = isValidBSTWithoutExtraSpace(root.right);
		}
		
		return isValidBST;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
//		root.right = right;
		
		
		
		System.out.println(isValidBSTWithoutExtraSpace(root));
		System.out.println(isValidBSTUsingExtraSpace(root));
	}
}