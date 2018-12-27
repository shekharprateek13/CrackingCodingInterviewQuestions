package dsalgoproblems.project.programcreek.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shekh
 */
public class SumRootToLeaf {
	
	public static void sumRootToLeaf(TreeNode node, List<TreeNode> l, List<List<TreeNode>> completeList){
		if(node.leftChild == null && node.rightChild == null){
			List<TreeNode> temp = new LinkedList<TreeNode>();
			temp.addAll(l);
			completeList.add(temp);
		}
		
		if(node.leftChild != null){
			l.add(node.leftChild);
			sumRootToLeaf(node.leftChild, l, completeList);
			l.remove(l.size() - 1);
		}
		
		if(node.rightChild != null){
			l.add(node.rightChild);
			sumRootToLeaf(node.rightChild, l, completeList);
			l.remove(l.size() - 1);
		}
	}
	
	public static int sumRootToLeaf(TreeNode node, int val, int sum){
		if(node == null)
			return sum;
		
		val = val*10 + node.data;
		
		if(node.leftChild == null && node.rightChild == null){
			sum += val;
			return sum;
		}
		
		sum = sumRootToLeaf(node.leftChild, val,sum) + sumRootToLeaf(node.rightChild, val, sum);
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		List<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		List<List<TreeNode>> completeList = new LinkedList<List<TreeNode>>();
		sumRootToLeaf(root, list, completeList);
		completeList.stream().forEach(System.out::println);

	}
}