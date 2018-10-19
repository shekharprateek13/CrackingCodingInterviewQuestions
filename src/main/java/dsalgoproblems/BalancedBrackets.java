package dsalgoproblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author shekh
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * Given strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.
 * Input Format: The first line contains a single integer, , denoting the number of strings. Each line of the subsequent lines consists of a single string,s,denoting a sequence of brackets.
 * Output Format: For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.
 * 
 * Sample Input: 
 * 	3
 *	{[()]}
 *  {[(])}
 *  {{[[(())]]}}
 * Sample Output
 * 	YES
 * 	NO
 * 	YES
 * Explanation
 *   The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 *   The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced. Thus, we print NO on a new line.
 *   The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 *
 */
public class BalancedBrackets {
	
	public static boolean isBalanced(String expression) {
		if(expression == null){
			return true;
		}
		boolean isBalanced = true;
		Deque<Character> stack = new ArrayDeque<Character>();
		Character temp;
		//{[()]}
		for(int i = 0;i < expression.length();i++){
			Character c = expression.charAt(i);
			switch(c){
			case '[':
			case '{':
			case '(':
				stack.push(c);
				break;
			case ']':
				temp = stack.peek();
				if(temp!=null && temp == '['){
					stack.pop();
				}else{
					isBalanced = false;
				}
				break;
			case '}':
				temp = stack.peek();
				if(temp!=null && temp == '{'){
					stack.pop();
				}else{
					isBalanced = false;
				}
				break;
			case ')':
				temp = stack.peek();
				if(temp!=null && temp == '('){
					stack.pop();
				}else{
					isBalanced = false;
				}
				break;
			}
			if(!isBalanced){
				break;
			}
		}
		return (isBalanced && stack.isEmpty());
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
		}
	}

}
