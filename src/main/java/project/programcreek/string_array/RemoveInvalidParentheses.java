package project.programcreek.string_array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author shekh
 */
public class RemoveInvalidParentheses {
	
	static Deque<String> QUEUE = new ArrayDeque<String>();
	static List<String> EXPLORED = new ArrayList<String>();
	
	public static boolean isValidString(String s){
		int openBracketCount = 0;
		int closedBracketCount = 0;
		for(int i = 0; i < s.length();i++){
			if(s.charAt(i) == '('){
				openBracketCount++;
			}else if(s.charAt(i)==')'){
				closedBracketCount++;
			}
			
			if(openBracketCount < closedBracketCount){
				return false;
			}
		}
		return openBracketCount == closedBracketCount;
	}
	
	public static List<String> getValidString(String input){
		List<String> returnList = new ArrayList<String>();
		QUEUE.add(input);
		boolean level = false;
		while(!QUEUE.isEmpty()){
			String node = QUEUE.poll();
			if(isValidString(node)){
				returnList.add(node);
				level = true;
			}
			EXPLORED.add(node);
			if(level) continue;
			for(int i = 0; i < node.length(); i++){
				String temp = node.substring(0,i) + node.substring(i+1);
				if(!EXPLORED.contains(temp)){
					QUEUE.add(temp);
					EXPLORED.add(temp);
					
				}
			}
		}
		return returnList;
	}

	public static void main(String[] args) {
		System.out.println(getValidString("()())()"));
	}
}