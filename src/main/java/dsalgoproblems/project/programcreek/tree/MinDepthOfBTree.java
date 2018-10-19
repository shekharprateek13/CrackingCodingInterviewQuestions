package dsalgoproblems.project.programcreek.tree;

import java.util.LinkedList;

/**
 * @author shekh....
 */
public class MinDepthOfBTree {

	public static int getMinDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		if(root.leftChild == null && root.rightChild == null)
			return 1;
		
		if(root.leftChild == null)
			return getMinDepth(root.rightChild) + 1;
		
		if(root.rightChild == null)
			return getMinDepth(root.leftChild) + 1;
		
		return Math.min(getMinDepth(root.leftChild),getMinDepth(root.rightChild));
	}
	
	public static int getMinDepthUsingLevelOrderTraversal(TreeNode root) {
		if(root == null)
			return 0;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> size = new LinkedList<Integer>();
		
		queue.add(root);
		size.add(0);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int count = size.poll();
			
			if(node.leftChild == null && node.rightChild == null)
				return count;
			
			if(node.leftChild != null){
				queue.add(node.leftChild);
				size.add(count + 1);
			}
			
			if(node.rightChild != null){
				queue.add(node.rightChild);
				size.add(count + 1);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(10);
		root.leftChild.leftChild.leftChild = new TreeNode(20);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		System.out.println(getMinDepthUsingLevelOrderTraversal(root));
	}
}