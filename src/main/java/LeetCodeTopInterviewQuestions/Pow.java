package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 * Implement pow(x, n).
 * Example 1:
 * 	 Input: 2.00000, 10
 * 	 Output: 1024.00000
 * 
 * Example 2:
 *   Input: 2.10000, 3
 *   Output: 9.26100
 */
public class Pow {

	public static double myPow(double x, int n) {
		double temp = x;
		int threshold = -1;
		if(x < 0 && n < 0) {
			threshold = (int)(-n + x);
		}else if(x < 0 && n > 0) {
			threshold = (int)(n + x);
		}else if(x > 0 && n < 0) {
			threshold = (int)-(n + x);
		}else if (x > 0 && n > 0) {
			threshold = (int)(n - x);;
		}
		
		if(n < 0){
			x = 1/x;
			temp = x;
		}
		
		int count = 1;
		while(count < threshold){
			temp = temp * temp;
			count += count; 
		}

		int difference = n - count;
		while(difference > 0){
			temp = x * temp;
			difference--;
		}
		return temp;
	}

	public static void main(String[] args){
//		System.out.println(myPow(34.00515,-3));
		System.out.println(myPow(2,10));
	}
}