package project.programcreek.dp;

/**
 * @author shekh
 */
public class MaxSubarraySum {
	/*
	 * Find the contiguous sub-array within an array (containing at least one number) which has the largest sum.
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous sub-array [4,−1,2,1] has the largest sum = 6.
	 */
	public static int maxSubArraySum(int[] nums){
		int currentMax = nums[0];
		int globalMax = nums[0];
		for(int i = 1; i < nums.length;i++){
			currentMax = Math.max(currentMax+nums[i],nums[i]);
			if(globalMax < currentMax){
				globalMax = currentMax;
			}
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		System.out.println(maxSubArraySum(new int[]{-2,1,-3,4,-1,2,-1,-5,40}));
	}
}