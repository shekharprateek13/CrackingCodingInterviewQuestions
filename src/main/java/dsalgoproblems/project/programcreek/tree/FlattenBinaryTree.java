/**
 * 
 */
package dsalgoproblems.project.programcreek.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author shekh
 *
 */
public class FlattenBinaryTree {
	
	public static void flattenBinaryTree(TreeNode root){
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode temp = root;
		
		while(temp != null || !stack.isEmpty()){
			
			if(temp.rightChild != null){
				stack.push(temp.rightChild);
			}
			
			if(temp.leftChild != null){
				temp.rightChild = temp.leftChild;
				temp.leftChild = null;
			}else if(!stack.isEmpty()){
				temp.rightChild = stack.pop();
			}
			temp = temp.rightChild;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		root.leftChild = new TreeNode(40);
		root.leftChild.leftChild = new TreeNode(30);
		root.leftChild.leftChild.leftChild = new TreeNode(20);
		root.leftChild.rightChild = new TreeNode(45);
		root.leftChild.rightChild.rightChild = new TreeNode(47);
		root.leftChild.rightChild.rightChild.leftChild = new TreeNode(46);
		root.leftChild.rightChild.rightChild.rightChild = new TreeNode(48);
		root.leftChild.rightChild.rightChild.rightChild.rightChild = new TreeNode(49);

		root.rightChild = new TreeNode(80);
		root.rightChild.leftChild = new TreeNode(70);
		root.rightChild.rightChild = new TreeNode(90);

		flattenBinaryTree(root);
		
		TreeNode node = root;
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.rightChild;
		}
	}
}