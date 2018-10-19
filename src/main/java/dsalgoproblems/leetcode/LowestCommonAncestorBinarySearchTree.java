package dsalgoproblems.leetcode;

/**
 * @author shekh
 */
class Node{
	int data;
	Node left, right;
	
	Node(){}

	Node(int item){
		data = item;
		left = right = null;
	}
}

public class LowestCommonAncestorBinarySearchTree {
	
	public static Node findLowestCommonAncestor(Node root, int n1, int n2){
		if(root == null) return null;
		
		if(root.data >= n1 && root.data <= n2){
			return root;
		}else if(root.data > n1 && root.data > n2){
			//Traverse the left subtree
			return findLowestCommonAncestor(root.left, n1, n2);
		}else{
			//Traverse the left subtree
			return findLowestCommonAncestor(root.right, n1, n2);
		}
	}
	
	public static void main(String[] args) {
		// Let us construct the BST shown in the above figure
		Node tree = new Node();
		tree = new Node(20);
		tree.left = new Node(8);
		tree.right = new Node(22);
		tree.left.left = new Node(4);
		tree.left.right = new Node(12);
		tree.left.right.left = new Node(10);
		tree.left.right.right = new Node(14);
		System.out.println(findLowestCommonAncestor(tree,4,22).data);
	}
}