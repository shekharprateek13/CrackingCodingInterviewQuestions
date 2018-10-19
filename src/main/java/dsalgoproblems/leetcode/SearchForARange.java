package dsalgoproblems.leetcode;

import java.util.Arrays;

/**
 * @author shekh
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. 
 */
public class SearchForARange {

	public static int[] getTargetIndex(int[] nums, int target, int left, int right, int[] targetIndex){
		int mid = (left+right)/2;

		if(left > right){
			if(targetIndex[0] > -1 && targetIndex[1] == 1){
				targetIndex[1] = targetIndex[0];
			}
			
			if(targetIndex[0] == -1 && targetIndex[1] > 1){
				targetIndex[0] = targetIndex[1];
			}
			return targetIndex;
		}

		if(nums[mid] == target){
			if((mid > 0 && mid < (nums.length - 1)) && (nums[mid-1] != target && nums[mid+1] != target)){
				targetIndex[0] = targetIndex[1] = mid;
			}else if(mid == 0 || nums[mid-1] != target){
				targetIndex[0] = mid;
				targetIndex[1] = getTargetIndex(nums, target, left, mid - 1, targetIndex)[1];
			}else if(mid == nums.length - 1 || nums[mid+1] != target){
				targetIndex[1] = mid;
				if(mid != nums.length - 1){
					targetIndex[0] = getTargetIndex(nums, target, left, mid - 1, targetIndex)[0];
				}else{
					targetIndex[0] = mid;
				}
			}else{
				targetIndex[0] = getTargetIndex(nums, target, left, mid - 1, targetIndex)[0];
				targetIndex[1] = getTargetIndex(nums, target, left, mid - 1, targetIndex)[1];
			}
		}
		
		if(nums[mid] > target){
			targetIndex = getTargetIndex(nums, target, left, mid - 1, targetIndex);
		}else if(nums[mid] < target){
			targetIndex = getTargetIndex(nums, target, mid + 1, right, targetIndex);
		}
		
		return targetIndex;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,2,2,2,2};
		int[] defaultTargetIndex = new int[]{-1,1};
		int[] targetIndex = getTargetIndex(nums,2,0,nums.length-1,defaultTargetIndex);
		System.out.println(targetIndex[0] + "::" + targetIndex[1]);
	}
}