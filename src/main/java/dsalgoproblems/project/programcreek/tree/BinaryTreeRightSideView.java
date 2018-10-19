package dsalgoproblems.project.programcreek.tree;

/**
 * @author shekh
 */
public class BinaryTreeRightSideView {
	
	static class MaxLevel{
		int maxLevel = 0;
	}
	
	public static void printRightSideView(TreeNode root, int level, MaxLevel maxLevel){
		if(root == null){
			return;
		}
		
		if(maxLevel.maxLevel < level){
			System.out.println(root.data);
			maxLevel.maxLevel = level;
		}
		
		printRightSideView(root.rightChild, level+1, maxLevel);
		printRightSideView(root.leftChild, level+1, maxLevel);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(5);
		root.leftChild.leftChild = new TreeNode(20);
		root.rightChild = new TreeNode(50);
		MaxLevel maxLevel = new MaxLevel();
		printRightSideView(root, 0, maxLevel);

	}

}
