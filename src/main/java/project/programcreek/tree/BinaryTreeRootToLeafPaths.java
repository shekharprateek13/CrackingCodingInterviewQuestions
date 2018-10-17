package project.programcreek.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shekh
 */
public class BinaryTreeRootToLeafPaths {

	public static void getAllRootToLeafPaths(TreeNode node, List<TreeNode> l, List<List<TreeNode>> completeBinaryTree) {
		if(node == null)
			return;

		if(node.leftChild == null && node.rightChild == null){
			List<TreeNode> temp = new LinkedList<TreeNode>();
			temp.addAll(l);
			completeBinaryTree.add(temp);
		}

		if(node.leftChild != null){
			l.add(node.leftChild);
			getAllRootToLeafPaths(node.leftChild, l, completeBinaryTree);
			l.remove(l.size() - 1);
		}

		if(node.leftChild != null){
			l.add(node.rightChild);
			getAllRootToLeafPaths(node.rightChild, l, completeBinaryTree);
			l.remove(l.size() - 1);
		}
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		root.rightChild.rightChild = new TreeNode(60);
		List<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		List<List<TreeNode>> completeList = new LinkedList<List<TreeNode>>();
		getAllRootToLeafPaths(root, list, completeList);
		System.out.println(completeList);
	}
}