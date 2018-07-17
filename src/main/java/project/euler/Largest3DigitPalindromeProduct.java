package project.euler;

/**
 * @author shekh
 */
public class Largest3DigitPalindromeProduct {

	public Largest3DigitPalindromeProduct() {

	}
	
	public static boolean isPalindrome(String s){
		if(s.compareTo(new StringBuilder(s).reverse().toString()) == 0)
			return true;
		return false;
	}
	
	public static boolean is3DigitProduct(int n){
		int quotient = 0;
		boolean is3DigitProduct = false;
		for(int i = 1;i < Math.sqrt(n);i++){
			if(n % i == 0){
				quotient = n/i;
				if(String.valueOf(i).length() == 3 && String.valueOf(quotient).length() == 3){
					System.out.println(i+"::"+quotient);
					is3DigitProduct = true;
				}
			}
		}
		return is3DigitProduct;
	}

	public static void main(String[] args) {
		int largestPalindrome = 999*999;
		for(int i = largestPalindrome; i > 10000; i--){
			if(Largest3DigitPalindromeProduct.isPalindrome(String.valueOf(i)) && Largest3DigitPalindromeProduct.is3DigitProduct(i)){
				largestPalindrome = i;
				break;
			}
		}
		System.out.println(largestPalindrome);
	}
}