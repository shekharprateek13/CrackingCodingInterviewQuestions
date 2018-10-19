package dsalgoproblems.leetcode;

/**
 * @author shekh
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {

	public static int getPivotIndex(int[] nums,int left,int right){
		int pivotIndex = -1;
		int mid = (left+right)/2;

		if(left >= right  || (mid == left)){
			return pivotIndex;
		}

		if(nums[mid] > nums[mid+1]){
			pivotIndex = (mid+1);
		}else if(nums[mid-1] > nums[mid]){
			pivotIndex = mid;
		}else{
			pivotIndex = getPivotIndex(nums, left,mid);
			if(pivotIndex == -1){
				pivotIndex = getPivotIndex(nums, mid,right);
			}
		}	
		return pivotIndex;
	}

	public static int binarySearch(int[] nums,int left,int right,int target){
		int targetIndex = -1;
		int mid = (left+right)/2;

		if(left > right){
			return -1;
		}

		if(nums[mid] == target){
			return mid;
		}

		if(nums[mid] < target){
			targetIndex = binarySearch(nums, mid + 1, right, target);
		}else if(nums[mid] > target){
			targetIndex = binarySearch(nums, left, mid - 1, target);
		}
		return targetIndex;
	}

	public static int search(int[] nums, int target) {
		int targetIndex = -1;
		int pivotIndex = -1;
		if(nums.length == 2){
			if((nums[0] > nums[1])){
				pivotIndex = 1;
			}else{
				pivotIndex = 0;
			}
		}else{
			pivotIndex = getPivotIndex(nums,0,(nums.length - 1));
		}

		if(pivotIndex == -1){
			targetIndex = binarySearch(nums, 0,nums.length - 1, target);
		}else{
			targetIndex = binarySearch(nums, 0,pivotIndex - 1, target);
			if(targetIndex == -1){
				targetIndex = binarySearch(nums,pivotIndex,nums.length - 1,target);
			}
		}
		return targetIndex;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,3,4,5,1};
		System.out.println(search(nums,1));
	}
}