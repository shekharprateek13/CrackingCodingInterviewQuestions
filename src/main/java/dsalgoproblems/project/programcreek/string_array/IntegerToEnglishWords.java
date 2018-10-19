package dsalgoproblems.project.programcreek.string_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shekh
 */
public class IntegerToEnglishWords {

	static Map<Integer,String> map = new HashMap<Integer,String>();
	static{
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
	}
	
	public static String getWordRepresentationOfNumber(int n){
		StringBuilder sbr = new StringBuilder();
		int quotient = -1;
		
		while(n > 0){
			if(n >= 1000000000){
				quotient = n/1000000000;
				sbr.append(map.get(quotient)).append(" Billion ");
				n = n % 1000000000;
			}else if(n >= 1000000){
				quotient = n/1000000;
				sbr.append(map.get(quotient)).append(" Million ");
				n = n % 1000000;
			}else if(n >= 1000){
				quotient = n/1000;
				sbr.append(map.get(quotient)).append(" Thousand ");
				n = n % 1000;
			}else if(n >= 100){
				quotient = n/100;
				sbr.append(map.get(quotient)).append(" Hundred ");
				n = n % 100;
			}else{
				if(n%10 == 0 || n < 20){
					sbr.append(" "+map.get(n));
					n = 0;
				}else if(n > 20){
					quotient = n / 10;
					sbr.append(" "+map.get(quotient*10));
					n = n % 10;
				}else{
					sbr.append(" "+map.get(n));
				}
			}
		}
		return sbr.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(getWordRepresentationOfNumber(22222));
	}
}