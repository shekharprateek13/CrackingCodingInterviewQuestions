package dsalgoproblems.project.programcreek.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author shekh
 *
 */
public class VerticalOrderTraversal {

	public static void verticalOrderTraversal(TreeNode root, Map<Integer,List<TreeNode>> map, int slope){
		if(root == null)
			return;
		
		List<TreeNode> treeNodeList = null;
		if(map.containsKey(slope)){
			treeNodeList = map.get(slope);
		}else{
			treeNodeList = new LinkedList<TreeNode>();
			map.put(slope,treeNodeList);
		}
		treeNodeList.add(root);
		
		verticalOrderTraversal(root.leftChild, map, slope - 1);
		verticalOrderTraversal(root.rightChild, map, slope + 1);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		root.rightChild.rightChild = new TreeNode(7);
		root.rightChild.rightChild.leftChild = new TreeNode(8);
		root.rightChild.rightChild.rightChild = new TreeNode(9);

		Map<Integer,List<TreeNode>> map = new HashMap<Integer,List<TreeNode>>();
		verticalOrderTraversal(root,map,0);
		
		System.out.println(map);
	}
}