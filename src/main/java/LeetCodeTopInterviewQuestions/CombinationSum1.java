package LeetCodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shekh
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * 	[1, 7],
 * 	[1, 2, 5],
 * 	[2, 6],
 * 	[1, 1, 6]
 * ]
 */
public class CombinationSum1 {
	public static List<List<Integer>> findCombinations(int[] nums,int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtracking(list,new ArrayList<Integer>(),nums,target,0);
		return list;
	}

	public static void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums,int target, int start){
		if(target < 0)return;
		else if(target == 0){ list.add(new ArrayList<Integer>(tempList)); }
		else{
			for(int i = start; i < nums.length; i++){
				tempList.add(nums[i]);
				backtracking(list, tempList, nums, target - nums[i],i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> list = findCombinations(new int[]{2, 3, 6, 7},7);
		for(List<Integer> tempList: list){
			System.out.println(tempList);
		}
	}
}