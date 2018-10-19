package dsalgoproblems.project.programcreek.dp;

/**
 * @author shekh
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much 
 * attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber3 {

	static class TreeNode {
		int val;
		TreeNode left; 
		TreeNode right;
	}
	
	public int rob(TreeNode root){
	    if(root == null)
	        return 0;
	 
	    int[] result = helper(root);
	    return Math.max(result[0], result[1]);
	}
	 
	public int[] helper(TreeNode root) {
	    if(root == null) {
	        int[] result = {0, 0};
	        return result;
	    }
	 
	    int[] result = new int[2];
	    int[] left = helper(root.left);
	    int[] right = helper(root.right);
	 
	    // result[0] is when root is selected, result[1] is when not. 
	    result[0] = root.val + left[1] + right[1];
	    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	 
	    return result;
	}
	
}
