package project.programcreek.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class PalindromePartitioning {

	public static List<List<String>> palindromePartitioning(String s){
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(s.isEmpty() || s==null){
			return result;
		}
		recurse(s,0,new ArrayList<String>(),result);
		return result;
	}
	
	public static void recurse(String s, int start, List<String> list, List<List<String>> result){
		if(start == s.length()){
			List<String> temp = new ArrayList<String>(list);
			result.add(temp);
			return;
		}
		
		for(int i = start+1;i <= s.length();i++){
			String str = s.substring(start,i);
			if(isPalindrome(str)){
				list.add(str);
				recurse(s,i,list,result);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static boolean isPalindrome(String s){
		StringBuilder inputStr = new StringBuilder(s);
		StringBuilder reverseStr = new StringBuilder(s).reverse();
		if((inputStr.toString().equals(reverseStr.toString()))){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(palindromePartitioning("aab"));
	}
}