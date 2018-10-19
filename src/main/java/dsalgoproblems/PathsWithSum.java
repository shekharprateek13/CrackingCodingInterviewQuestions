package dsalgoproblems;

/**
 * @author shekh
 */
public class PathsWithSum {
	
	static int numPaths;

	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(){

		}

		TreeNode(int data){
			this.data = data;
		}
	}

	public static void recurse(TreeNode node,int target){
		if(node == null){
			if(target > 0){
				target = target + node.data;
			}
		}

		target = target - node.data;

		if(target == 0){
			numPaths += 1;
		}
		
		if(node.left!=null){
			recurse(node.left,target);
		}
		if(node.right!=null){
			recurse(node.right,target);
		}

	}

	public static void main(String[] args){
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(5);
		tree.left.left = new TreeNode(3);
		tree.left.left.left = new TreeNode(3);
		tree.left.left.right = new TreeNode(-2);
		
		tree.left.right = new TreeNode(2);
		tree.left.right.right = new TreeNode(1);
		
		tree.right = new TreeNode(-3);
		tree.right.right = new TreeNode(11);
		recurse(tree,8);
		System.out.println(numPaths);
	}
}