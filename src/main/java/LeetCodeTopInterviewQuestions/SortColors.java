package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
 * then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space? 
 */
public class SortColors {

	public void sortColors(int[] nums){
		int low = 0, mid = 0, high = nums.length - 1;
		int temp =  -1;
		while(mid <= high){
			switch(nums[mid]){
			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				mid++;
				low++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
				break;
			}
		}
	}
	
	public static void main(String[] args) { }
}