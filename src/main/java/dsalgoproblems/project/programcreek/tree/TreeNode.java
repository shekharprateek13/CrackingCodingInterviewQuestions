/**
 * 
 */
package dsalgoproblems.project.programcreek.tree;

/**
 * @author shekh
 *
 */
public class TreeNode {
	int data;
	TreeNode leftChild;
	TreeNode rightChild;
	
	TreeNode(int data){
		this.data = data;
	}
	
	@Override
	public String toString(){
		return " "+data;
	}
}
