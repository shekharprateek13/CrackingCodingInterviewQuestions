package dsalgoproblems.project.programcreek.dp;

/**
 * @author shekh
 */
public class MaxSubarrayProduct {

	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
	 */
	public static int maxProductSubArray(int[] nums){
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];
		max[0] = min[0] = nums[0];
		int result = Integer.MIN_VALUE;
		int i = 1;
		
		for(;i < nums.length;i++){
			if(nums[i] > 0){
				max[i] = Math.max(nums[i],max[i-1]*nums[i]);
				min[i] = Math.min(nums[i],min[i-1]*nums[i]);
			}else{
				max[i] = Math.max(nums[i],min[i-1]*nums[i]);
				min[i] = Math.min(nums[i],max[i-1]*nums[i]);
			}
			if(nums[i]>0){
				max[i]=Math.max(nums[i], max[i-1]*nums[i]);
				min[i]=Math.min(nums[i], min[i-1]*nums[i]);
			}else{
				max[i]=Math.max(nums[i], min[i-1]*nums[i]);
				min[i]=Math.min(nums[i], max[i-1]*nums[i]);
			}
		}

		for(i = 0; i < max.length; i++){
			if(max[i] > result){
				result = max[i];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(maxProductSubArray(new int[]{0,0,-2,0}));
	}
}