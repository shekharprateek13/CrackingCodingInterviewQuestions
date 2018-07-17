package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement{
	public static int recurse(int[] nums,int start,int end){
		int mid = (start+end)/2;
		if(mid < nums.length - 1 && mid > 0){
			if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]){
				return mid;
			}
		}
		return -1;
	}

	public static int findPeakElement(int[] nums){
		int start = 0;
		int end = nums.length - 1;
		int result = -1;

		while(result < 0){
			result = recurse(nums,start,end);
			if(result > 0) break;
			result = recurse(nums,start,(start+end)/2);
			if(result > 0) break;
			result = recurse(nums,(start+end)/2,end);
		}
		return result;
	}

	public static void main(String[] args){
		System.out.println(FindPeakElement.findPeakElement(new int[]{1,2}));
	}
}