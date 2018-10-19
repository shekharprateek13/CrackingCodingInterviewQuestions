package dsalgoproblems.project.programcreek.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class WordBreak {
	
	public static boolean wordBreak(String s, List<String> dictionary){
		int[] position = new int[s.length()+1];
		
		for(int i = 0; i < position.length;i++){
			position[i] = -1;
		}
		
		position[0] = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(position[i] == -1)continue;
			for(int j = i+1; j <= s.length();j++){
				String subStr = s.substring(i,j);
				if(dictionary.contains(subStr)){
					position[j] = i;
				}
			}
		}
		return position[s.length()] != -1;
	}
	
	public static int[] wordBreakII(String s, List<String> list){
		
		
		return null;
	}

	public static void main(String[] args) {
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak("leetcodes",dict));
	}
}