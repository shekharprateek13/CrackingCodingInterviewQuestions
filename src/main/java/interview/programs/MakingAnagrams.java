package interview.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given two strings, and , that may or may not be of the same length, determine the minimum number of character deletions required to 
 * make and anagrams. Any characters can be deleted from either of the strings.
 * 
 * Input Format:
 * The first line contains a single string.
 * The second line contains a single string.
 * 
 * Constraints
 * 	- It is guaranteed that and consist of lower case English alphabetic letters (i.e., through ).
 * 
 * Output Format
 * 	- Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.
 * 
 * Sample Input
 * 	- cde
 *  - abc
 * 
 * Sample Output - 4
 * 
 * Explanation
 * We delete the following characters from our two strings to turn them into anagrams of each other:
 *     Remove d and e from cde to get c.
 *     Remove a and b from abc to get c.
 * 
 * We must delete 4 characters to make both strings anagrams, so we print on a new line.
 *  
 */
public class MakingAnagrams {
	public static Map<Character,Integer> getCharacterCountMap(String inputString){
		Map<Character,Integer> charCountMap = new HashMap<Character,Integer>();
		for(int i = 0;i < inputString.length();i++){
			Character temp = inputString.charAt(i);
			if(charCountMap.containsKey(temp)){
				charCountMap.put(temp,charCountMap.get(temp)+1);
			}else{
				charCountMap.put(temp, 1);
			}
		}

		return charCountMap;
	}
	public static int numberNeeded(String first, String second) {
		if(first==null && second == null){
			return 0;
		}else if(first == null){
			return first.length();
		}else if(second == null){
			return second.length();
		}
		
		Map<Character,Integer> firstStrCharCountMap = getCharacterCountMap(first);
		Map<Character,Integer> secondStrCharCountMap = getCharacterCountMap(second);

		int minDeletionCount = 0;
		for(Character c1:firstStrCharCountMap.keySet()){
			if(secondStrCharCountMap.containsKey(c1)){
				if(firstStrCharCountMap.get(c1) != secondStrCharCountMap.get(c1)){
					int diff = firstStrCharCountMap.get(c1) - secondStrCharCountMap.get(c1);
					diff = (diff > 0)?diff:(-1*diff);
					minDeletionCount += diff;
				}
				firstStrCharCountMap.put(c1,0);
				secondStrCharCountMap.put(c1,0);
			}
		}
		
		for(Integer value:firstStrCharCountMap.values()){
			minDeletionCount += value;
		}
		
		for(Integer value:secondStrCharCountMap.values()){
			minDeletionCount += value;
		}
		return minDeletionCount;
	}
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
