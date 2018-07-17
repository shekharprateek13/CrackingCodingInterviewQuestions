package project.programcreek.string_array;

/**
 * @author shekh
 */
public class MinimumSizeSubArraySum {

	public static int minSubArrayLen(int s, int[] nums) {
		if(nums==null||nums.length==0)
			return 0;

		int i=0; 
		int j=0;
		int sum=0;
		int minLen = Integer.MAX_VALUE;

		while(j<nums.length){
			if(sum<s){
				sum += nums[j];
				j++;        
			}else{
				minLen = Math.min(minLen, j-i);
				if(i==j-1)
					return 1;

				sum -=nums[i];
				i++;
			}
		}

		while(sum>=s){
			minLen = Math.min(minLen, j-i);
			sum -=nums[i++];
		}
		return minLen==Integer.MAX_VALUE? 0: minLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] S = new int[]{2,3,1,2,4,3};
		int target = 7;
		System.out.println("Min Length:" + minSubArrayLen(target,S));
	}
}