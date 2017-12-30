package LeetCodeTopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {

	public static int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		int n = s.length();
		int length = 0,i = 0, j = 0; 
		for(int startIndex = 0, endIndex = 0; startIndex < n && endIndex < n;){
			Character tempChar = s.charAt(endIndex);
			if(map.containsKey(tempChar)){
				int tempIndex = map.get(tempChar);
				startIndex = startIndex <= tempIndex ? (tempIndex + 1): startIndex;
				map.put(tempChar,endIndex);
			}else{
				map.put(tempChar,endIndex);
			}
			if(length < (endIndex - startIndex + 1)){
				i = startIndex;
				j = endIndex;
				length = (endIndex - startIndex + 1);
			}
			endIndex++;
		} 
		System.out.println(s.substring(i,j+1));
		return length;
	}
	
	public static void main(String[] args) {
		System.out.println(LongestNonRepeatingSubstring.lengthOfLongestSubstring("abcbbcbb"));
	}
}