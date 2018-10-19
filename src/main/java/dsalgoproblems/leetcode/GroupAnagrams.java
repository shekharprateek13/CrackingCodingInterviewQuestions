package dsalgoproblems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shekh
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ] 
 */
public class GroupAnagrams {

	public static String countCharacters(String s){
		s = s.toLowerCase();
		List<Integer> list = new LinkedList<Integer>();
		int listPosition = 0; 
		for(int i = 0; i < 26; i++){
			list.add(0);
		}

		for(Character c: s.toCharArray()){
			listPosition = c - 97;
			list.set(listPosition, (list.get(listPosition)+1));
		}
		return list.toString();
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> tempMap = new HashMap<String,List<String>>();
		String tempStr = null;
		List<String> tempList = null;
		for(String s:strs){
			tempStr = countCharacters(s);
			if(tempMap.containsKey(tempStr)){
				tempList = tempMap.get(tempStr);
				tempList.add(s);
				tempMap.put(tempStr, tempList);
			}else{
				tempList = new ArrayList<String>();
				tempList.add(s);
				tempMap.put(tempStr, tempList);
			}
		}

		return new ArrayList(tempMap.values());
	}

	public static void main(String[] args){
		//	System.out.println(countCharacters("aaabbccc"));
		String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> tempList = groupAnagrams(str);
		for(List<String> l:tempList){
			System.out.println(l);
		}
		String patternString = ".*http://.*";

		Pattern pattern = Pattern.compile(patternString);

		Matcher matcher = pattern.matcher("");
//		boolean matches = matcher.resematches();

	}
}