package LeetCodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shekh
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers{

	public static List<List<Integer>> findPermutations(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		permutation(list,new ArrayList<Integer>(),nums,0);
		return list;
	}

	public static List<List<Integer>> permutation(List<List<Integer>> list, List<Integer> tempList, int[] nums,int start){
		if(nums.length == tempList.size()){
			list.add(tempList);
			tempList = new ArrayList<Integer>();
		}

		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			permutation(list, tempList, nums, i+1);
		}
		return list;
	}

	public static void main(String[] args){
		List<List<Integer>> list = findPermutations(new int[]{1,2,3});
		for(List<Integer> tempList: list){
			System.out.println(tempList);
		}
	}
}