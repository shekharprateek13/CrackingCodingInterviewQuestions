package dsalgoproblems.project.programcreek.tree;

/**
 * @author shekh
 */
public class SymmetricTree {

	public static boolean isSymmetricTree(TreeNode node1, TreeNode node2){
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 != null && node2 != null && node1.data == node2.data)
			return isSymmetricTree(node1.leftChild, node2.rightChild) && 
						isSymmetricTree(node1.rightChild, node2.leftChild);
		
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(2);
		root.rightChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(3);
		root.leftChild.rightChild = new TreeNode(4);
		root.rightChild.leftChild = new TreeNode(4);
		root.rightChild.rightChild = new TreeNode(30);
		System.out.println(isSymmetricTree(root.leftChild, root.rightChild));
	}
}