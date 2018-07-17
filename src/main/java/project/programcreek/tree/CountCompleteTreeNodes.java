package project.programcreek.tree;

/**
 * @author shekh
 */
public class CountCompleteTreeNodes {

	public static int countNodes(TreeNode root){
		if(root == null)
			return 0;

		int leftHeight = getLeftHeight(root) + 1;
		int rightHeight = getRightHeight(root) + 1;

		if(leftHeight == rightHeight){
			return (2<<(leftHeight - 1))-1;
		}else{
			return countNodes(root.leftChild) + countNodes(root.rightChild) + 1;
		}
	}

	public static int getLeftHeight(TreeNode node){
		if(node == null)
			return 0;

		int height = 0;
		while(node.leftChild!=null){
			height++;
			node = node.leftChild;
		}
		return height;
	}

	public static int getRightHeight(TreeNode node){
		if(node == null)
			return 0;

		int height = 0;
		while(node.rightChild!=null){
			height++;
			node = node.rightChild;
		}
		return height;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		System.out.println(countNodes(root));
	}
}