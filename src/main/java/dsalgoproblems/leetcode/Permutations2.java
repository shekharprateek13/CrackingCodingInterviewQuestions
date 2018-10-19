package dsalgoproblems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shekh
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class Permutations2{
	
	public static void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums){
		if(tempList.size() == nums.length){ 
			list.add(new ArrayList<Integer>(tempList));}
		else{
			for(int i = 0; i < nums.length; i++){
				if(tempList.contains(i))continue;
				tempList.add(nums[i]);
				backtracking(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	public static boolean isValidTime(String hour,String minute){
		int intHour = Integer.parseInt(hour);
		int intMinute = Integer.parseInt(minute);
		if(intHour >= 0 && intHour <= 23){
			if(intMinute >= 0 && intMinute <= 59)
				return true;
		}
		return false;
	}
	
	public static List<String> getValidTimes(List<List<Integer>> input){
		List<String> timeList = new ArrayList<String>();
		for(List<Integer> list: input){
			String hour = String.valueOf(list.get(0)) + String.valueOf(list.get(1));
			String minute = String.valueOf(list.get(2)) + String.valueOf(list.get(3));
			if(isValidTime(hour,minute)){
				timeList.add(hour+":"+minute);
			}
		}
		return timeList;
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtracking(list,new ArrayList<Integer>(),nums);
		return list;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> completeList = new ArrayList<List<Integer>>();
		backtracking(completeList, new ArrayList<Integer>(),nums);
		for(List<Integer> temp: completeList){
			System.out.println(temp);
		}
		/*
		String s = "00:00";
		String temp = s.replace(":","");
		int[] tempInt = new int[4];
		for(int i = 0; i < temp.length(); i++){
			tempInt[i] = temp.charAt(i) - 48;
		}
		
		List<List<Integer>> list = permute(tempInt);
		List<String> validTimes = getValidTimes(list);
		validTimes.add(s);
		Collections.sort(validTimes);
		int position = 0;
		for(int i = 0; i < validTimes.size(); i++){
			if(validTimes.get(i).equals(s)){
				position = i+1;
				break;
			}
		}
		
		if(position == validTimes.size()){
			System.out.println(validTimes.get(0));
		}else{
			System.out.println(validTimes.get(position));
		}
	*/}
}