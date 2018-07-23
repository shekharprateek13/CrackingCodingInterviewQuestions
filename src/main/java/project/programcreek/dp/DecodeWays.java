package project.programcreek.dp;

import java.util.HashMap;

public class DecodeWays {

	/*
	 * Trailing 0s in n! = Count of 5s in prime factors of n!
                  = floor(n/5) + floor(n/25) + floor(n/125) + ....
	 */
	public static int findTrailingZeros(int n) {
		// Initialize result
		int count = 0;

		// Keep dividing n by powers of 5 and update count
		for (int i = 5; n / i >= 1; i *= 5)
			count += n / i;

		return count;
	}

	public static String convertToTitle(int n) {
		if(n <= 0){
			throw new IllegalArgumentException("Input is not valid!");
		}

		StringBuilder sb = new StringBuilder();

		while(n > 0){
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			sb.append(ch);
		}

		sb.reverse();
		return sb.toString();
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";

		String result = "";

		// is result is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}

		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);

		// quotient 
		long res = num / den;
		result += String.valueOf(res);

		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;

		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder); 
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
		}

		return result;
	}

	public static void main(String...args) {
		System.out.println(findTrailingZeros(10));
	}
}