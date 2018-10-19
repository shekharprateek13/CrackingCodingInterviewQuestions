package dsalgoproblems.leetcode;

class TreeNode{
	int data;
	TreeNode left, right;
	
	TreeNode(){}

	TreeNode(int item){
		data = item;
		left = right = null;
	}
}

public class LowestCommonAncestorBinaryTree{

	public static TreeNode findLowestCommonAncestor(TreeNode node, int n1, int n2){
		if(node == null) return null;
		
		if(node.data == n1 || node.data == n2){
			return node;
		}
		
		TreeNode leftSubtreeNode = findLowestCommonAncestor(node.left, n1, n2);
		TreeNode rightSubtreeNode = findLowestCommonAncestor(node.right, n1, n2);
		
		if(leftSubtreeNode != null && rightSubtreeNode != null){
			return node;
		}
		
		return (leftSubtreeNode != null && rightSubtreeNode == null)? leftSubtreeNode:rightSubtreeNode;
	}

	public static void main(String[] args){
		/*TreeNode tree = new TreeNode();
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        TreeNode ancestor = findLowestCommonAncestor(tree,2,4);
        System.out.println(ancestor.data);*/
		long i;
		System.out.println("X.............");
		System.out.println(1<<31);
		for(i = 1 << 31; i > 0; i = i/2){
			System.out.println("Y::::"+i);
		}
		System.out.println("Y.............");
		
	}
}