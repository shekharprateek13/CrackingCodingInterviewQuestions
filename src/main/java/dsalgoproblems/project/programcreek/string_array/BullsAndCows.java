package dsalgoproblems.project.programcreek.string_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shekh
 * https://www.programcreek.com/2014/05/leetcode-bulls-and-cows-java/
 */
public class BullsAndCows {

	public static String getHint(String input, String guess){
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int bullsCount = 0, cowsCount = 0;
		for(int i = 0;i < input.length();i++){
			char c1 = input.charAt(i);
			char c2 = guess.charAt(i);

			if(c1 == c2){
				bullsCount++;
			}else{
				if(map.containsKey(c1)){
					map.put(c1,map.get(c1) + 1);
				}else{
					map.put(c1,1);
				}
			}
		}

		for(int i = 0;i < input.length();i++){
			char c1 = input.charAt(i);
			char c2 = guess.charAt(i);

			if(c1 != c2){
				if(map.containsKey(c2)){
					cowsCount++;
					if(map.get(c2) == 1){
						map.remove(c2);
					}else{
						map.put(c2,map.get(c2) - 1);
					}
				}
			}
		}

		System.out.println("Bulls Count: "+bullsCount);
		System.out.println("Cows Count: "+cowsCount);
		return "";
	}

	public static void main(String[] args) {
		//		getHint("1807","7810");
		String s = "juliasamanthasamanthajulia";//"xabcdey";
		String x = "ant*as";//"ab*de";

		int startIndexS1 = -1;
		int startIndexX1 = 0;
		boolean isWildcardUsed = false;
		for(int i = 0; i < s.length(); i++){
			if((s.charAt(i) == x.charAt(startIndexX1) || (x.charAt(startIndexX1) == '*') && !isWildcardUsed)){
				if(startIndexX1 == 0){
					startIndexS1 = i;
				}
				
				if(x.charAt(startIndexX1) == '*'){
					isWildcardUsed = true;
				}
				startIndexX1 += 1;
			}else{
				startIndexX1 = 0;
				isWildcardUsed = false;
			}
			if(startIndexX1 == x.length()){
				break;
			}
		}
		System.out.println(startIndexS1);

	}

}
