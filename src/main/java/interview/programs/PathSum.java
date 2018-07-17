package interview.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shekh
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which might be positive or negative). 
 * Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root or 
 * a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class PathSum {

	static class TreeNode{
		int data;
		TreeNode left, right;

		TreeNode(){}

		TreeNode(int item){
			data = item;
			left = right = null;
		}
	}

	public static int countPath(TreeNode node,int currentSum, int target, int count){
		if(node == null){
			return 0;
		}

		if(currentSum + node.data == target){
			return 1;
		}else{
			currentSum = currentSum + node.data;
		}

		if(node.left == null && node.right == null){
			return 0;
		}

		if(node.left != null){
			count += countPath(node.left, currentSum, target, count);
		}

		if(node.right != null){
			count += countPath(node.right, currentSum, target, count);
		}

		return count;
	}

	public static int getHeight(TreeNode node, int height){
		if(node == null){
			return height;
		}
		return Math.max(getHeight(node.left,height+1),getHeight(node.right,height+1));
	}

	public static int diameterOfTree(TreeNode n, int maxDiameter){
		if(n == null){
			return maxDiameter;
		}

		int leftHeight = getHeight(n.left,0);
		int rightHeight = getHeight(n.right,0);

		maxDiameter = Math.max(maxDiameter, leftHeight+rightHeight+1);

		maxDiameter = diameterOfTree(n.left, maxDiameter);
		maxDiameter = diameterOfTree(n.right, maxDiameter);
		return maxDiameter;
	}
	
	public static void main(String[] args) {
		/*TreeNode tree = new TreeNode();
        tree = new TreeNode(6);
        tree.left = new TreeNode(5);
//        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(-1);
        tree.left.right.right = new TreeNode(-7);
//        tree.right.right = new TreeNode(2);
		System.out.println(diameterOfTree(tree,0));*/
		List<String> list = new ArrayList<String>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		String s = "  ";
		System.out.println(s.trim().isEmpty());
		List<String> l = new ArrayList<String>();
		StringBuilder sbr  = new StringBuilder("123");
		System.out.println(sbr.reverse().toString());
   }
}