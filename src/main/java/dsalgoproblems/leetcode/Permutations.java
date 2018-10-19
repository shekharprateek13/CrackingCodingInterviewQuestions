package dsalgoproblems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shekh
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 *  ]
 */
public class Permutations {

	public static void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums){
		if(tempList.size() == nums.length){ 
			list.add(new ArrayList<Integer>(tempList));}
		else{
			for(int i = 0; i < nums.length; i++){
				if(tempList.contains(nums[i]))continue;
				tempList.add(nums[i]);
				backtracking(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtracking(list,new ArrayList<Integer>(),nums);
		return list;
	}

	public static void main(String[] args){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		backtracking(result,new ArrayList<Integer>(),new int[]{1,2,3,4});

		for(List<Integer> temp: result){
			System.out.println(temp);
		}
	}
}