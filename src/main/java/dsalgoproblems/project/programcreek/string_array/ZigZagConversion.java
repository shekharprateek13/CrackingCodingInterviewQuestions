package dsalgoproblems.project.programcreek.string_array;

/**
 * @author shekh
 */
public class ZigZagConversion {

	/*
	 * PAYPALISHIRING: 
	 * P     A     H     N
	 * A  P  L  S  I  I  G
	 * Y     I     R
	 */
	public static String zigZagConversion1(String s, int numRows) {
		if (numRows == 1)
			return s;

		StringBuilder sb = new StringBuilder();
		int step = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1){
				for (int j = i; j < s.length(); j = j + step) {
					sb.append(s.charAt(j));
				}
			}else{
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;

				while (j < s.length()) {
					sb.append(s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
		return sb.toString();
	}

	//InCorrect
	public static String zigZagConversion2(String str, int target){
		char[] S = str.toCharArray();
		StringBuilder tempStr = new StringBuilder();
		for(int i = 0; i < target; i++){
			tempStr = tempStr.append(S[i]);
			if(target - i == target || Math.abs(target - i) == 1){
				int j = i + target + 1;
				while(j < S.length){
					tempStr = tempStr.append(S[j]);
					j = j + target + 1;
				}
			}else if(target - i < target){
				int j = i + (target - i);
				while(j < S.length){
					tempStr = tempStr.append(S[j]);
					j = j + (target - i);   
				}
			}
		}
		return tempStr.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		System.out.println(str);
		System.out.println(zigZagConversion1(str,3));
		System.out.println(zigZagConversion2(str,3));
		System.out.println("--------------------------");
		System.out.println(zigZagConversion1(str,4));
		System.out.println(zigZagConversion2(str,4));
	}
}