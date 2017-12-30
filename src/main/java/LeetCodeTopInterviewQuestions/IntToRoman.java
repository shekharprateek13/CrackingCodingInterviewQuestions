package LeetCodeTopInterviewQuestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman {
	public static Map<Integer,String> CONSTANTS = new LinkedHashMap<Integer,String>();
	static{
		CONSTANTS.put(1000,"M");
		CONSTANTS.put(900,"CM");
		CONSTANTS.put(500,"D");
		CONSTANTS.put(400,"CD");
		CONSTANTS.put(100,"C");
		CONSTANTS.put(90,"XC");
		CONSTANTS.put(50,"L");
		CONSTANTS.put(40,"XL");
		CONSTANTS.put(10,"X");
		CONSTANTS.put(9,"IX");
		CONSTANTS.put(5,"V");
		CONSTANTS.put(4,"IV");
		CONSTANTS.put(1,"I");
	}

	public String intToRoman(int num) {
		int quotient = 0;
		StringBuilder sbr = new StringBuilder();
		for(Integer key:CONSTANTS.keySet()){
			quotient = num/key;
			if(quotient > 0){
				String value = CONSTANTS.get(key);
				for(int i = 0; i < quotient; i++){
					sbr.append(value);
				}
				num = num - quotient*key;
			}

			if(num == 0)break;
		}
		return sbr.toString();
	}

	public static void main(String[] args) {
		System.out.println(new IntToRoman().intToRoman(1140));

	}
}