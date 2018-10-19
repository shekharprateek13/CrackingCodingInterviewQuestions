/**
 * 
 */
package dsalgoproblems.project.programcreek.tree;

/**
 * @author shekh
 *
 */
public class TreeTraversals {
	
	public static void inOrder(TreeNode root){
		if(root == null)
			return;
		
		inOrder(root.leftChild);
		System.out.print(root+" ");
		inOrder(root.rightChild);
	}
	
	public static void preOrder(TreeNode root){
		if(root == null)
			return;
		
		System.out.print(root +" ");
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}
	
	public static void postOrder(TreeNode root){
		if(root == null)
			return;
		
		postOrder(root.leftChild);
		postOrder(root.rightChild);
		System.out.print(root+" ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(5);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(7);
		root.rightChild = new TreeNode(30);
		root.rightChild.leftChild = new TreeNode(15);
		root.rightChild.rightChild = new TreeNode(35);
		System.out.println("Inorder Traversal!!!");
		inOrder(root);
		System.out.println("\nPreorder Traversal!!!");
		preOrder(root);
		System.out.println("\nPostorder Traversal!!!");
		postOrder(root);
	}
}