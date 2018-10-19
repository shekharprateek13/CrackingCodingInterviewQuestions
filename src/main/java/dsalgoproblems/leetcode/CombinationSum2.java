package dsalgoproblems.leetcode;

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
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 *  ]
 */
public class CombinationSum2 {

	public static List<List<Integer>> findCombinations(int[] nums,int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtracking_KSubsetSize(list,new ArrayList<Integer>(),nums,target,0,2);
		return list;
	}

	public static void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums,int target, int start){
		if(target < 0)return;
		else if(target == 0) { 
			list.add(new ArrayList<Integer>(tempList));
		}else {
			for(int i = start; i < nums.length; i++){
				if(i > start && nums[i] == nums[i-1]) {
					continue;
				}
				tempList.add(nums[i]);
				backtracking(list, tempList, nums, target - nums[i],i+1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void backtracking_KSubsetSize(List<List<Integer>> list, List<Integer> tempList, int[] nums,int target, int start, int k) {
		if(target < 0 || tempList.size() > k)return;
		else if(target == 0 && tempList.size() == k) { 
			list.add(new ArrayList<Integer>(tempList)); 
		}else {
			for(int i = start; i < nums.length; i++) {
				if(i > start && nums[i] == nums[i-1]){ continue; }
				tempList.add(nums[i]);
				backtracking_KSubsetSize(list, tempList, nums, target - nums[i],i+1,k);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args){
		List<List<Integer>> list = findCombinations(new int[]{1,2,3,5,6,7,9},9);
		for(List<Integer> tempList: list){
			System.out.println(tempList);
		}
	}
}