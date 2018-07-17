package LeetCodeTopInterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author shekh
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets 
 * in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> solution = new LinkedList<List<Integer>>();
		List<Integer> list = null;
		Map<Integer,Integer> map = null;
		for(int i = 0; i < nums.length; i++){
			map = new HashMap<Integer,Integer>();
			int difference = 0 - nums[i];
			for(int j = i+1; j < nums.length; j++){
				list = new LinkedList<Integer>();
				if(map.containsKey(difference - nums[j])){
					list.add(nums[i]);
					list.add(difference - nums[j]);
					list.add(nums[j]);
					Collections.sort(list);
					if(!solution.contains(list))solution.add(list);
				}else{
					map.put(nums[j],j);
				}
			}
		}
		return solution;
	}
	
	public static void main(String[] args) {
		int[] S = new int[]{-1, 0, 1, 2, -1, -4};
//		System.out.println(threeSum(S).size());
		for(List<Integer> list:threeSum(S)){
			System.out.println(list);
		}
	}
}