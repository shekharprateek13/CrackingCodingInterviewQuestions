/**
 * 
 */
package project.programcreek.string_array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shekh
 *
 */
public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] input = new int[]{4,3,100,200,1,2};
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int element: input){
			hashSet.add(element);
		}
		
		int maxLength = 0;
		for(int element:input){
			int count = 1;
			int left = element - 1;
			int right = element + 1;
			
			while(hashSet.contains(left)){
				count++;
				hashSet.remove(left);
				left--;
			}
			
			while(hashSet.contains(right)){
				count++;
				hashSet.remove(right);
				right++;
			}
			maxLength = Math.max(maxLength, count);
		}
		System.out.println("Max Length: "+maxLength);
	}
}