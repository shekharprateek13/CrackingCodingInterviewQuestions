package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 *
 */
public class DiameterOfBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static int recurse(TreeNode node, int pathLength, int maxLength){
		if(node == null){
			return pathLength;
		}

		/*maxLength = (pathLength > maxLength)?pathLength : maxLength;
        return Math.max(maxLength,recurse(node.left,pathLength + 1,maxLength) + recurse(node.right,pathLength + 1,maxLength));*/

		if(node.left!=null){
			pathLength = recurse(node.left,pathLength,maxLength) + 1;
		}

		//maxLength = (pathLength > maxLength)?pathLength : maxLength;

		if(node.right != null){
			pathLength += Math.max(maxLength,recurse(node.right,pathLength,maxLength) + 1);
		}

		return pathLength;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		int pathLength = recurse(root,0,0);
		System.out.println(pathLength);
	}
}