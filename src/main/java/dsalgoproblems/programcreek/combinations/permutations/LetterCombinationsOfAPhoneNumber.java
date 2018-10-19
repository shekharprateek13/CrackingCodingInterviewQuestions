package dsalgoproblems.programcreek.combinations.permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shekh
 */
public class LetterCombinationsOfAPhoneNumber {
	
	static Map<Integer,String> map = new HashMap<Integer,String>();
	static{
		map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    map.put(0, "");
	}
	
	public static List<String> getLetterCombinations(int num){
		List<String> completeList = new ArrayList<String>();
		List<String> temp = null;
		DFS(completeList,String.valueOf(num),"",0);
		return completeList;
	}
	
	public static void DFS(List<String> completeList, String inputNum, String combinations, int currentIndex){
		if(combinations.length() == inputNum.length()){
			completeList.add(combinations);
		}
		
		if(currentIndex == inputNum.length())
			return;
		
		char s = inputNum.charAt(currentIndex);
		String mapping = map.get(s - '0');
		for(int i = 0; i < mapping.length(); i++){
			combinations += mapping.charAt(i);
			DFS(completeList,inputNum,combinations,currentIndex+1);
			combinations = combinations.substring(0,combinations.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(getLetterCombinations(234));
	}
}