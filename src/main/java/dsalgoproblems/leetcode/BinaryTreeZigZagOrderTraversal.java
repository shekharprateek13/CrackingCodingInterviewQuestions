package dsalgoproblems.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author shekh
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *  
 */
public class BinaryTreeZigZagOrderTraversal{

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<List<Integer>> zigzag(TreeNode root) {
		List<List<Integer>> parentList = new LinkedList<List<Integer>>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int counter = 0;
		while(!stack.isEmpty()){
			if(counter%2 == 0){
				ArrayList<TreeNode> tempList1 = new ArrayList<TreeNode>();
				ArrayList<Integer> tempList2 = new ArrayList<Integer>();
				while(!stack.isEmpty()){
					tempList1.add(stack.pop());
					tempList2.add(stack.pop().val);
				}
				Collections.reverse(tempList1);
				Collections.reverse(tempList2);
				parentList.add(tempList2);
				for(TreeNode node:tempList1){
					stack.push(node.left);
					stack.push(node.right);
				}
			}

			if(counter%2 == 1){
				ArrayList<TreeNode> list = new ArrayList<TreeNode>();
				while(!stack.isEmpty()){
					list.add(stack.pop());
				}
				//				parentList.add(list);
			}
		}
		return parentList;
	}

	public static void main(String[] args) {

	}
}