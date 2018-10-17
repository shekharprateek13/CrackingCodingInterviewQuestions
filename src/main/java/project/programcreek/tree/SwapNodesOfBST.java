package project.programcreek.tree;

/**
 * @author shekh
 */
public class SwapNodesOfBST {
	
	static TreeNode pre = null;
	static TreeNode first = null;
	static TreeNode middle = null;
	static TreeNode last = null;

	public static void swapNodes(TreeNode node) {
		if(node == null)
			return;
		
		swapNodes(node.leftChild);
		
		if(pre != null && pre.data > node.data) {
			if(first == null){
				first = pre;
				middle = node;
			}else{
				last = node;
			}
		}
		pre = node;
		swapNodes(node.rightChild);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(5);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(35); 
		root.rightChild = new TreeNode(30);
		root.rightChild.leftChild = new TreeNode(15);
		root.rightChild.rightChild = new TreeNode(7);
		TreeTraversals.inOrder(root);
		swapNodes(root);
		System.out.println("\n--------------------------------");
		System.out.println(first);
		System.out.println(middle);
		System.out.println(last);
		System.out.println("--------------------------------");
		if(first!=null && last!=null){
			TreeNode temp = new TreeNode(first.data);
			first.data = last.data;
			last.data = temp.data;
		}else if(first!=null && middle!=null){
			TreeNode temp = new TreeNode(middle.data);
			first.data = middle.data;
			middle.data = temp.data;
		}
		TreeTraversals.inOrder(root);
	}
}