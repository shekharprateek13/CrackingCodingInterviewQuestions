package dsalgoproblems.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shekh
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */
public class PartitionLabels {
	
	public static List<Integer> partitionLabels(String S) {
        int[] countArray = new int[26];
        List<Integer> returnList = new LinkedList<Integer>();
        for(int i = 0; i < S.length(); i++){
            countArray[S.charAt(i) - 'a'] = i;
        }
        
        int j = 0, anchor = 0;
        for(int i = 0; i < S.length(); i++){
        	j = Math.max(j, countArray[S.charAt(i) - 'a']);
        	if(i == j){
        		returnList.add((j - anchor) + 1);
        		anchor = i+1;
        	}
        }
        return returnList;
    }

	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}
}