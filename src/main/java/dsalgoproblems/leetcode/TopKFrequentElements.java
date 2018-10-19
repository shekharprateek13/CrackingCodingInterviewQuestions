package dsalgoproblems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shekh
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		List<Integer> returnArray = new ArrayList<Integer>(k);
		
		for(Integer i:nums){
			if(map.containsKey(i)){
				map.put(i,map.get(i)+1);
			}else{
				map.put(i,1);
			}
		}
		
		for(Integer i:map.keySet()){
			if(buckets[map.get(i)] == null){
				buckets[map.get(i)] = new ArrayList<Integer>();
			}
			buckets[map.get(i)].add(i);
		}
		
		for(int i = buckets.length - 1; i > 0; i--){
			if(buckets[i] != null){
				returnArray.addAll(buckets[i]);
			}
		}
		return returnArray.subList(0,k);
	}

	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},3));
	}
}