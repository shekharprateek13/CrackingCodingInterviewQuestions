package dsalgoproblems;

/**
 * @author shekh
 */
public class SingleNumber2 {
	
	public static int singleNumber(int[] A) {
		int x = 0;
		for (int a : A) {
			x = x ^ a;
		}
		return x;
	}
	
	public static int SingleNumber2(int[] A){
		int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}

	public static void main(String[] args) {
//		System.out.println(singleNumber(new int[]{3,4,3}));
		System.out.println(SingleNumber2(new int[]{3,4,3,2,2,1,2,4,3,4}));
	}
}