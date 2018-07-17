package project.programcreek.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shekh
 */
public class SerializeAndDeserializeBTree {
	
	static int index = 0;
	public static void serializeBinaryTree(TreeNode root, ArrayList<String> list){
		if(root == null){
			list.add("#");
			return;
		}
		
		list.add(root.data+"");
		serializeBinaryTree(root.leftChild, list);
		serializeBinaryTree(root.rightChild, list);
	}
	
	public static TreeNode deSerializeBinaryTree(ArrayList<String> list){
		if(index == list.size() || list.get(index) == "#"){
			index += 1;
			return null;
		}
		
		TreeNode node = new TreeNode(Integer.parseInt(list.get(index)));
		index += 1;
		node.leftChild = deSerializeBinaryTree(list);
		node.rightChild = deSerializeBinaryTree(list);
		
		return node;
	}
	
	public static boolean validatePreOrderDeserializedTree(List<String> deserializedList){
		LinkedList<String> stack = new LinkedList<String>();
		
//		for(int i = 0; i < )
		
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		LevelOrderTraversal.levelOrderTraversal(root);
		System.out.println();
		ArrayList<String> list = new ArrayList<String>();
		serializeBinaryTree(root, list);
		System.out.println(list);
		System.out.println();
		TreeNode newRoot = deSerializeBinaryTree(list);
		LevelOrderTraversal.levelOrderTraversal(newRoot);
	}
}