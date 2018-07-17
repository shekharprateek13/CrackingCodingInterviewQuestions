package interview.programs;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author shekh
 */
public class SortHashMapOnValues {

	public static void main(String[] args) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('a',10);
		map.put('b',25);
		map.put('c',5);
		map.put('d',12);
		map.put('e',10);
		map.put('f',100);
		map.put('g',23);
		map.put('h',67);
		map.put('i',8);
		
		List<Map.Entry<Character,Integer>> list = new LinkedList<Map.Entry<Character,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				if(o1.getValue() - o2.getValue() > 1){
					return -1;
				}else if(o1.getValue() - o2.getValue() < 1){
					return 1;
				}else{
					return 0;
				}
			}
		});
		
		Map<Character,Integer> newMap = new LinkedHashMap<Character,Integer>();
		for(Map.Entry<Character,Integer> entry:list){
			newMap.put(entry.getKey(),entry.getValue());
		}
		
		System.out.println(newMap);
	}
}