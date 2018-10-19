package dsalgoproblems.project.euler;

/**
 * @author shekh
 */
public class PrimeNumberGenerator {

	public PrimeNumberGenerator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		long prime = -1;
		for(int i = 1;i < (10001 - 2); i++){
			prime = 6*i - 1;
			prime = 6*i + 1;
		}
		System.out.println(prime);
	}
}