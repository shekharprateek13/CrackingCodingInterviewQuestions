package dsalgoproblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shekh
 * Algorithm:
 * 1) Declare a character stack S.
 * 2) Now traverse the expression string exp.
      a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
      b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
 * 3) After complete traversal, if there is some starting bracket left in stack then “not balanced”
 */
public class ValidateParentheses {


	/*
	 * Validate Parentheses containing only () 
	 */
	public static boolean validateParentheses(String s){
		Deque<Character> deque = new ArrayDeque<Character>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				deque.push(s.charAt(i));
			}else{
				if(deque.peek() == null){
					return false;
				}

				if(deque.peek() == '('){
					deque.pop();
				}
			}
		}
		return deque.isEmpty();
	}

	/*
	 * Validate Parentheses containing only () and * where * could represent (,) or an empty string...  
	 */
	public static boolean validateParenthesesWithWildcard(String s){
		Deque<Character> deque = new ArrayDeque<Character>();
		int wildCardCount = 0;
		for(int i = 0; i < s.length(); i++){

			if(s.charAt(i) == '('){
				deque.push(s.charAt(i));
			}else if(s.charAt(i) == '*'){
				wildCardCount++;
			}else{
				if(deque.peek() == null){
					if(wildCardCount > 0)
						wildCardCount--;
					else{
						return false;
					}
				}else{
					deque.pop();
				}
			}
		}
		return deque.size() == wildCardCount;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Validate Parenthese without Wildcard!!!");
		System.out.println(validateParentheses("((()))"));
		System.out.println(validateParentheses("()()()"));
		System.out.println(validateParentheses("(()))"));
		System.out.println(validateParentheses("("));

		System.out.println("Validate Parenthese with Wildcard!!!");
		//		System.out.println(validateParenthesesWithWildcard("(((****)))"));
		System.out.println(validateParenthesesWithWildcard("()*)()"));
		System.out.println(validateParenthesesWithWildcard("((*)))"));
		System.out.println(validateParenthesesWithWildcard("("));
		System.out.println(validateParenthesesWithWildcard("(((*))"));

	}
}