package dsalgoproblems.project.programcreek.string_array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shekh
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = ")))()())(((())))()()()";
		Deque<Character> stack = new ArrayDeque<Character>();
		int maxLength = 0;
		int currentLength = 0;
		for(Character c: input.toCharArray()){
			if(c == ')'){
				if(stack.isEmpty()){
					stack.push(c);
				}else if(stack.peek() == '('){
					currentLength = currentLength + 2;
					stack.pop();
					maxLength = Math.max(maxLength, currentLength);
				}else{
					stack.push(c);
					currentLength = 0;
					maxLength = Math.max(maxLength, currentLength);
				}
			}else{
				stack.push(c);
			}
		}
		System.out.println("Max Length: "+maxLength);
	}
}