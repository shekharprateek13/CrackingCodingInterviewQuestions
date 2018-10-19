package dsalgoproblems.project.euler;

/**
 * @author shekh
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 */
public class SmallestMultiple {
	
	public static long getLCM(long x1, long x2){
		int gcd = 0;
		for(int i = 1; i <= x1 && i <= x2; i++){
			if(x1 % i == 0 && x2 % i == 0){
				gcd = i;
			}
		}
		return (x1*x2)/gcd;
	}
	
	public static void main(String[] args) {
		long lcm = 1;
		for(int i = 1; i <= 20; i++){
			lcm = SmallestMultiple.getLCM(lcm, i);
			System.out.println(lcm);
		}
		System.out.println(lcm);
	}
}