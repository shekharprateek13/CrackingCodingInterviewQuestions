package project.programcreek.combinations.segmentTree;

/**
 * @author shekh
 */
public class RangeSumQuery {
	
	static class STreeNode{
		int startRange;
		int endRange;
		int sum;
		STreeNode leftChild;
		STreeNode rightChild;
	}
	
	public static int sumRange(STreeNode root, int start, int end){
		if(root == null || end < root.startRange || start > root.endRange || end < start){
			return 0;
		}
		
		if(start <= root.startRange && end >= root.endRange){
			return root.sum;
		}
		
		int mid = (root.startRange + (root.endRange - root.startRange))/2;
		int result = sumRange(root.leftChild,start,Math.min(mid,end)) + sumRange(root.rightChild,Math.max(mid+1,start),end);
		return result;
	};

	public static STreeNode buildTree(int[] nums, int left, int right){
		if(nums == null || left > right){
			return null;
		}
		
		if(left == right){
			STreeNode temp = new STreeNode();
			temp.startRange = temp.endRange = left;
			temp.sum = nums[left];
			return temp;
		}
		
		STreeNode node = new STreeNode();
		node.startRange = left;
		node.endRange = right;
		
		int mid = (left + (right - left))/2; 
		node.leftChild = buildTree(nums,left,mid);
		node.rightChild = buildTree(nums,mid+1,right);
		
		node.sum = node.leftChild.sum + node.rightChild.sum;	
		
		return node;
	}
	
	public static void main(String[] args) {
		
	}
}