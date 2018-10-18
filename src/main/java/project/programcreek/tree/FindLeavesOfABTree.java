/*
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * Example:
 * Given binary tree:
 *
 *        1
 *       / \
 *      2   3
 *     / \     
 *    4   5    
 *  Returns [4, 5, 3], [2], [1].
 * 
 */
package project.programcreek.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author akhaurishekhar
 */
public class FindLeavesOfABTree {
	
	static List<TreeNode> leafNodes = new ArrayList<TreeNode>();
	
	public static void collectLeafNodes(TreeNode node, List<TreeNode> l, List<List<TreeNode>> completeList) {
		if(node == null)
			return;
		
		if(node.leftChild == null && node.rightChild == null) {
			List<TreeNode> temp = new LinkedList<TreeNode>();
			temp.addAll(l);
			completeList.add(temp);
			leafNodes.add(node);
		}
		
		if(node.leftChild!=null) {
			l.add(node.leftChild);
			collectLeafNodes(node.leftChild,l,completeList);
			l.remove(l.size() - 1);
		}
		
		if(node.rightChild!=null) {
			l.add(node.rightChild);
			collectLeafNodes(node.rightChild,l,completeList);
			l.remove(l.size() - 1);
		}
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		
		List<List<TreeNode>> completeList = new ArrayList<List<TreeNode>>();
		List<TreeNode> temp = new LinkedList<TreeNode>();
		temp.add(root);
		
		while(root.leftChild!=null || root.rightChild!=null) {
			collectLeafNodes(root,temp,completeList);
			System.out.println("Leaf Nodes: "+ leafNodes);
			for(List<TreeNode> l:completeList) {
				if(l.size() >= 2) {
					TreeNode secondLast = l.get(l.size() - 2);
					TreeNode last = l.get(l.size() - 1);
					if(secondLast.rightChild != null && secondLast.rightChild.data == last.data) {
						secondLast.rightChild = null;
					}else if(secondLast.leftChild != null && secondLast.leftChild.data == last.data){
						secondLast.leftChild = null;
					}
				}
				l.remove(l.size() - 1);
			}	
			temp.clear();
			temp.add(root);
			leafNodes.clear();
			completeList.clear();
		}
		System.out.println(temp);
		root = null;
	}
}