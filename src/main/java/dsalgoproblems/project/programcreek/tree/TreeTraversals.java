/**
 * 
 */
package dsalgoproblems.project.programcreek.tree;

import java.util.LinkedList;

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

	public static void iterativeInOrderTraversal(TreeNode root){
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode temp = root;

		while(!stack.isEmpty() || temp!=null){

			while(temp != null){
				stack.push(temp);
				temp = temp.leftChild;
			}

			temp = stack.pop();
			System.out.print(temp+" ");

			temp = temp.rightChild;
		}
	}

	public static void preOrder(TreeNode root){
		if(root == null)
			return;
		
		System.out.print(root +" ");
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}

	public static void iterativePreOrderTraversal(TreeNode root){
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.push(root);

		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.print(temp+" ");

			if(temp.rightChild!=null){
				stack.push(temp.rightChild);
			}

			if(temp.leftChild!=null){
				stack.push(temp.leftChild);
			}
		}
	}
	
	public static void postOrder(TreeNode root){
		if(root == null)
			return;
		
		postOrder(root.leftChild);
		postOrder(root.rightChild);
		System.out.print(root+" ");
	}

	public static void iterativePostOrderTraversal(TreeNode root){
		LinkedList<TreeNode> stack1 = new LinkedList<>();
		LinkedList<TreeNode> stack2 = new LinkedList<>();
		stack1.push(root);

		while(!stack1.isEmpty()){
			TreeNode temp = stack1.pop();

			stack2.push(temp);

			if(temp.leftChild!=null){
				stack1.push(temp.leftChild);
			}

			if(temp.rightChild!=null){
				stack1.push(temp.rightChild);
			}
		}

		while(!stack2.isEmpty()){
			System.out.print(stack2.pop()+" ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		root.leftChild = new TreeNode(40);
		root.leftChild.leftChild = new TreeNode(30);
		root.leftChild.leftChild.leftChild = new TreeNode(20);
		root.leftChild.rightChild = new TreeNode(45);
		root.leftChild.rightChild.rightChild = new TreeNode(47);
		root.leftChild.rightChild.rightChild.leftChild = new TreeNode(46);
		root.leftChild.rightChild.rightChild.rightChild = new TreeNode(48);
		root.leftChild.rightChild.rightChild.rightChild.rightChild = new TreeNode(49);


		root.rightChild = new TreeNode(80);
		root.rightChild.leftChild = new TreeNode(70);
		root.rightChild.rightChild = new TreeNode(90);

		System.out.println("Inorder Traversal!!!");
		inOrder(root);

		System.out.println("\nIterative Inorder Traversal!!!");
		iterativeInOrderTraversal(root);

		System.out.println("\n\nPreorder Traversal!!!");
		preOrder(root);

		System.out.println("\nIterative PreOrder Traversal!!!");
		iterativePreOrderTraversal(root);

		System.out.println("\n\nPostorder Traversal!!!");
		postOrder(root);

		System.out.println("\nIterative PostOrder Traversal!!!");
		iterativePostOrderTraversal(root);
	}
}