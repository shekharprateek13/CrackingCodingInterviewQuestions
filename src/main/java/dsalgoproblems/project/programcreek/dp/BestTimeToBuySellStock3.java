/**
 * Say you have an array for which the i'th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most 2 transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
 * transactions at the same time (i.e:, you must sell the stock before you buy again).
 */
package dsalgoproblems.project.programcreek.dp;

/**
 * @author shekh
 */
public class BestTimeToBuySellStock3 {
	
	public static int getMaximumProfit(int[] nums){
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		
		left[0] = 0;
		right[nums.length - 1] = 0;
		
		int leftMin = nums[0];
		int leftMax = 0;
		
		for(int i = 0; i < nums.length; i++) {
			left[i] = Math.max(leftMax,nums[i] - leftMin);
			leftMin = Math.min(leftMin,nums[i]);
		}
		
		int rightMin = right[nums.length - 1];
		int rightMax = 0;
		for(int i = nums.length - 1; i > 0 ; i--){
			right[i] = Math.max(rightMax, nums[i] - rightMin);
			rightMax = Math.max(rightMax,nums[i]);
		}
		
		int maxProfit = Integer.MIN_VALUE;
		for(int i = 0; i < left.length; i++){
			if((left[i] + right[i]) > maxProfit){
				maxProfit = left[i] + right[i];
			}
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{100,180,260,310,40,535,695};
		System.out.println(getMaximumProfit(nums));
	}
}