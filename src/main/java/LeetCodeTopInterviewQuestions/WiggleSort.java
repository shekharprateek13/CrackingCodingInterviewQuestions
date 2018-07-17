package LeetCodeTopInterviewQuestions;

import java.util.Arrays;
import java.util.List;

/**
 * @author shekh
 *
 */
public class WiggleSort {

	public static int[] wiggleSort(int[] nums) {
		int temp = 0;
		for(int i = 1; i < nums.length; i++){
			if(i % 2 == 1){
				if(nums[i-1] >= nums[i]){
					temp = nums[i-1];
					nums[i-1] = nums[i];
					nums[i] = temp;
				}
				if(i < (nums.length - 1) && nums[i+1] >= nums[i]){
					temp = nums[i+1];
					nums[i+1] = nums[i];
					nums[i] = temp;
				}                
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
		
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}

	}

}
