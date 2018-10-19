package dsalgoproblems.leetcode;

/**
 * @author shekh
 */
public class DistanceBetweenTwoNodesOfABinaryTree {

	static class TreeNode{
		int data;
		TreeNode left, right;

		TreeNode(){}

		TreeNode(int item){
			data = item;
			left = right = null;
		}

		@Override
		public String toString(){
			return String.valueOf(data);
		}
	}
	
	public static int recurse(Node n, Node n1, Node n2, int pathLength){
		if(n == null)
			return pathLength - 1;
		
		if(n.data == n1.data || n.data == n2.data){
			return pathLength;
		}
		
		int leftPathLength = recurse(n.left,n1,n2,pathLength + 1);
		int rightPathLength = recurse(n.right,n1,n2,pathLength + 1);
		
		return leftPathLength + rightPathLength;
	}
	
	public static int getPathLength(Node n, Node n1, Node n2, int pathLength){
		if(n == null)
			return pathLength - 1;
		
		if(n.data == n1.data || n.data == n2.data){
			return pathLength;
		}
		
		int leftPathLength = recurse(n.left,n1,n2,pathLength + 1);
		int rightPathLength = recurse(n.right,n1,n2,pathLength + 1);
		
		return leftPathLength + rightPathLength;
	}

	public static void main(String[] args){
		TreeNode tree = new TreeNode();
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.right.left.right = new TreeNode(8);
        
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(5);
//        recurse(tree,n1,n2,);
	}
}
