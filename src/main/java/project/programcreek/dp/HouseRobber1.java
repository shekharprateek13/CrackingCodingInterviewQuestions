package project.programcreek.dp;

/**
 * @author shekh
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it 
 * will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money 
 * you can rob tonight without alerting the police.
 */
public class HouseRobber1 {

	public static int robMaximumMoney(int[] nums){
		if(nums==null||nums.length==0)
			return 0;

		if(nums.length==1)
			return nums[0];
		
		int[] cache = new int[nums.length+1];

		cache[0] = nums[0];
		cache[1] = Math.max(nums[0],nums[1]);

		for(int i = 2; i < nums.length; i++){
			cache[i] = Math.max(cache[i-1],nums[i]+cache[i-2]);
		}

		return cache[nums.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(robMaximumMoney(new int[]{1,2,3,4,5,6}));
	}
}