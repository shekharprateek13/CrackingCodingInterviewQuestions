package dsalgoproblems.programcreek.combinations.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class GenerateParentheses {
	
	public static void dfs(List<String> list,String s, int left, int right){
		if(left > right){
			return;
		}
		
		if(left == 0 && right == 0){
			list.add(s);
			return;
		}
		
		if(left > 0){
			dfs(list,s+"(",left-1,right);
		}
		
		if(right > 0){
			dfs(list,s+")",left,right-1);
		}
	}
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		dfs(list,"",2,2);
		System.out.println(list);
	}
}