package project.programcreek.tree;

/**
 * @author shekh
 */
public class BinaryTreeRightSideView {
	static int max = 0;
	public static void printRightSideView(TreeNode root, int currLevel){
		if(root == null)
			return;
		
		if(max < currLevel){
			System.out.println(root.data+" ");
			max = currLevel;
		}
		
		printRightSideView(root.rightChild,currLevel + 1);
		printRightSideView(root.leftChild,currLevel + 1);
	}
	
	/*public static void printRightSideViewIteratively(TreeNode root, int currLevel){
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		
		list.add(root);
		while(!list.isEmpty()){
			TreeNode node = list.poll();
			for(int i = 0; i < list.size(); i++){
				
			}
		}
	}*/
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(5);
		root.leftChild.leftChild = new TreeNode(20);
		root.rightChild = new TreeNode(50);
		printRightSideView(root, 0);

	}

}
