package project.programcreek.string_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author shekh
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. (Note: The result may be very large, so you need to 
 * return a string instead of an integer.)
 */
public class LargestNumber {
	
	public static String getLargestNumber(int[] nums){
		StringBuilder sbr = new StringBuilder();
		final List<String> list = new ArrayList<String>();
		for(int i:nums){
			list.add(String.valueOf(i));
		}
		
		Collections.sort(list, new Comparator<String>(){
			public int compare(String o1, String o2) {
				System.out.println(list);
				return (o2+o1).compareTo(o1+o2);
			}
		});
		System.out.println(list);
		
		for(String s:list){
			sbr.append(s);
		}
		
		while(sbr.charAt(0) == '0' && sbr.length() > 1){
			sbr.deleteCharAt(0);
		}
		
		return sbr.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{3,30,34,5,9};
		System.out.println(getLargestNumber(nums));
	}
}