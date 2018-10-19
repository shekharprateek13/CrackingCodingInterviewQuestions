package dsalgoproblems.leetcode;

import java.util.Arrays;

/**
 * 
 * @author shekh
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
public class NextPermutation {

	public static int[] nextPermutation(int[] nums){
		if(nums.length < 2){
			return nums;
		}
		int breakIndex = -1;
		int swapElement = -1;
		int swapIndex = -1;
		for(int i = nums.length - 1; i > 0; i--){
			if(nums[i - 1] < nums[i]){
				breakIndex = i;
				break;
			}
		}
		
		if(breakIndex >= 0){
			swapElement = nums[breakIndex];
			for(int i = breakIndex; i < nums.length; i++){
				if(nums[i] > nums[breakIndex - 1] && nums[i] <= swapElement){
					swapIndex = i;
				}
			}
			swapElement = nums[swapIndex];
			nums[swapIndex] = nums[breakIndex - 1];
			nums[breakIndex - 1] = swapElement;
		}else{
			breakIndex = 0;
		}
		//Sort the numbers in increasing order from BreakIndex to End...
		Arrays.sort(nums, breakIndex, nums.length);
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,4,8,5,3};
		nums = nextPermutation(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i]+" ");
		}
	}
}