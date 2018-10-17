package project.programcreek.string_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shekh
 */
public class LongestSubstringKUniqueChars {
	
	public static int getLengthOfLongestKUniqueChars(String s, int k){
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int left = 0;
		int maxLength = 0;
		for(int i = 0; i < s.length();i++){
			Character c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}else{
				map.put(c, 1);
			}
			
			while(map.size() > k) {
				if(maxLength < (i - left)) {
					maxLength = i-left;
					System.out.println(s.substring(left,i));
				}
				
				int count = map.get(s.charAt(left));
				if(count == 1) {
					map.remove(s.charAt(left));
				}else {
					count--;
					map.put(s.charAt(left),count);
				}
				left++;
			}
		}
		return maxLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcbbbbcccbdddadacb";
		System.out.println(LongestSubstringKUniqueChars.getLengthOfLongestKUniqueChars(s,3));
	}
}