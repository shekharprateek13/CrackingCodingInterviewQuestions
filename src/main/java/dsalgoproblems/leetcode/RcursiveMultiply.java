/**
 * 
 */
package dsalgoproblems.leetcode;

/**
 * @author shekh
 */
public class RcursiveMultiply {
	
	public static int recurse(int a, int b, int count, int sum){
		if(count > b){
			for(int i = count - b; i > 0; i--){
				sum = sum - a;
			}
			return sum;
		}else{
			sum += sum;
			count += count;
			return recurse(a,b,count,sum);
		}
	}

	public static void main(String[] args) {
		System.out.println(recurse(2,10,1,2));
	}
}