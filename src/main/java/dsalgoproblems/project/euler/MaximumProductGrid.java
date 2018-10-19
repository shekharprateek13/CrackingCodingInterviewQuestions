package dsalgoproblems.project.euler;

/**
 * @author shekh
 */
public class MaximumProductGrid {

	public static long calculateFactors(long n){
		long numFactors = 0;
		for(long i = 1; i <= Math.sqrt(n); i++){
			if(n%i == 0){
				if(n/i == i){
					numFactors++;
				}else{
					numFactors+=2;
				}
			}
		}
		return numFactors;
	}
	
	public static long calculateNthTriangularNumber(long n){
		return n*(n+1)/2;
	}
	
	public static void main(String[] args) {
		long nthTriangularNumber = 1;
		long numFactors = 1;
		long n = 1;
		while(true){
			nthTriangularNumber = calculateNthTriangularNumber(n);
			numFactors = calculateFactors(nthTriangularNumber);
			System.out.println(n + " Traingular Number : "+nthTriangularNumber);
			System.out.println("Number of Factors : "+numFactors);
			if(numFactors == 500){
				System.out.println(nthTriangularNumber);
				break;
			}else{
				n++;
			}
		}
	}
}