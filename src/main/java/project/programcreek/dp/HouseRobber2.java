package project.programcreek.dp;

/**
 * @author shekh
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much 
 * attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {
	
	public static int robHousesInCircle(int[] nums){
		if(nums==null||nums.length==0)
			return 0;

		if(nums.length==1)
			return nums[0];
		
		int max1 = robMaximumMoney(nums,0,nums.length - 1);
		int max2 = robMaximumMoney(nums,1,nums.length);
		
		return Math.max(max1, max2);
	}
	
	public static int robMaximumMoney(int[] nums, int start,int end){
		int[] cache = new int[nums.length+1];
		
		cache[0] = nums[start];
		cache[1] = Math.max(nums[start],nums[start+1]);

		for(int i = start + 2; i < end; i++){
			cache[i] = Math.max(cache[i-1],nums[i]+cache[i-2]);
		}

		return cache[nums.length - 1];
	}

	public static void main(String[] args) {
		int[] temp = new int[]{1,2,3,4,5,6};
		System.out.println(robHousesInCircle(temp));

	}

}
