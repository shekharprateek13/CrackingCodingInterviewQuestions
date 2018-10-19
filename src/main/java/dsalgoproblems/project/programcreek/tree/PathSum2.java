package dsalgoproblems.project.programcreek.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shekh
 */
public class PathSum2 {

	static List<TreeNode> leafNodes = new ArrayList<TreeNode>();

	public static boolean printPathToLeaf(TreeNode root, TreeNode leaf){
		if(root == null)
			return false;

		if(leaf.data == root.data || (printPathToLeaf(root.leftChild, leaf)) || (printPathToLeaf(root.rightChild,leaf))){
			System.out.print(root + "->");
			return true;
		}
		
		System.out.println();
		return false;
	}

	/*
	 * Using Queue
	 */
	public static void pathSum(TreeNode root, int target){
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> size = new LinkedList<Integer>();

		queue.add(root);
		size.add(root.data);

		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int currentSum = size.poll();

			if(node.leftChild == null && node.rightChild == null && currentSum == target){
				leafNodes.add(node);
			}

			if(node.leftChild != null){
				queue.add(node.leftChild);
				size.add(currentSum + node.leftChild.data);
			}

			if(node.rightChild != null){
				queue.add(node.rightChild);
				size.add(currentSum + node.rightChild.data);
			}
		}
	}

	/*
	 * Using Recursion
	 */
	public static boolean recursePathSum(TreeNode root,int target){
		if(root == null){
			return false;
		}

		if((root.leftChild == null && root.rightChild == null) && root.data == target){
			return true;
		}

		return recursePathSum(root.leftChild,target - root.data) || recursePathSum(root.rightChild,target - root.data);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.leftChild = new TreeNode(10);
		root.leftChild.leftChild = new TreeNode(3);
		root.leftChild.rightChild = new TreeNode(15);
		root.rightChild = new TreeNode(30);
		root.rightChild.leftChild = new TreeNode(25);
		root.rightChild.rightChild = new TreeNode(-5);
		pathSum(root,45);
		System.out.println(leafNodes);
		for(TreeNode leafNode:leafNodes){
			printPathToLeaf(root, leafNode);
		}
		/*
		 *            20
		 *	        /    \
		 *	      10     30
		 *	     /  \   /  \
		 *      3   15 25  -5
		 */
	}
}