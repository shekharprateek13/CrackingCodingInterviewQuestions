package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT. 
 */

public class DivideTwoIntegers {

	public static int divide(int dividend, int divisor) {
		if (dividend == 0 || divisor == 0) return 0;
		long d1 = dividend, d2 = divisor;
		long result = divideLong(Math.abs(d1), Math.abs(d2));
		result = d1 * d2 < 0 ? -result : result;
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return Integer.MAX_VALUE;
		return (int) result;
	}

	private static long divideLong(long dividend, long divisor) {
		if (dividend < divisor) return 0;
		long sum = divisor, divideTimes = 1;
		while (sum + sum <= dividend) {
			sum += sum;
			divideTimes += divideTimes;
		}
		return divideTimes + divideLong(dividend - sum, divisor);
	}

	public static void main(String[] args) {
		System.out.println(DivideTwoIntegers.divide(133,27));
	}
}