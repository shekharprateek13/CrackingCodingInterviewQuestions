package project.programcreek.tree;

/**
 * @author shekh
 */
public class InorderSuccessorBST {
	
	public static TreeNode inOrderSuccessor(TreeNode root, TreeNode target){
		if(root == null)
			return null;
		
		TreeNode next = null;
		TreeNode temp = root;
		while(temp!=null && temp.data != target.data){
			if(temp.data > target.data){
				next = temp;
				temp = temp.leftChild;
			}else{
				temp = temp.rightChild;
			}
		}
		
		if(temp == null)
			return null;
		
		if(temp.rightChild == null){
			return next;
		}
		
		temp = temp.rightChild;
		while(temp.leftChild!=null)
			temp = temp.leftChild;
		
		return temp;
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(5);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(7);
		root.rightChild = new TreeNode(30);
		root.rightChild.leftChild = new TreeNode(15);
		root.rightChild.rightChild = new TreeNode(35);
		System.out.println(inOrderSuccessor(root,new TreeNode(15)));
	}
}