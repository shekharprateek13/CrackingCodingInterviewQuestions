/**
 * 
 */
package dsalgoproblems.project.euler;

/**
 * @author shekh
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these 
 * multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class MultiplesOf3And5 {
	
	public static void main(String[] args) {
		int sumOf3Multiples = 3;
		int sumOf5Multiples = 5;
		
		while(true){
			if(sumOf5Multiples <= 1000){
				sumOf5Multiples += sumOf5Multiples;
			}
			
			if(sumOf3Multiples <= 1000){
				sumOf3Multiples += sumOf3Multiples;
			}
			
			if(sumOf3Multiples > 1000 && sumOf5Multiples > 1000){
				break;
			}
		}
		
		while(true){
			if(sumOf3Multiples > 1000){
				sumOf3Multiples -= 3;
			}
			
			if(sumOf5Multiples > 1000){
				sumOf5Multiples -= 5;
			}
			
			if(sumOf3Multiples <= 1000 && sumOf5Multiples <= 1000){
				break;
			}
		}
		
		System.out.println("Sum Of 3 Multiples: "+sumOf3Multiples);
		System.out.println("Sum Of 5 Multiples: "+sumOf5Multiples);
	}
}