/**
 * Say you have an array for which the ith element is the price of a given stock on day i..........
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
 * transactions at the same time (ie, you must sell the stock before you buy again).
 */
package dsalgoproblems.project.programcreek.dp;

/**
 * @author shekh
 */
public class BestTimeToBuySellStock2 {
	
	public static int getMaximumProfit(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		
		int maxProfit = 0;
		int diff = 0;
		
		for(int i = 1; i < nums.length; i++){
			diff = nums[i] - nums[i-1];
			if(diff > 0){
				maxProfit+= diff;
			}
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{100,180,260,310,40,535,695};
		System.out.println(getMaximumProfit(nums));
	}
}