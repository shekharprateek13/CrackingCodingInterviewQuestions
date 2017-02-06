package interview.programs;

public class ShortestPalindrome {
	
	public boolean isPalindrome(String s){
		StringBuilder inputStr = new StringBuilder(s);
		StringBuilder reverseStr = new StringBuilder(s).reverse();
		if((inputStr.toString().equals(reverseStr.toString()))){
			return true;
		}
		return false;
	}
	
	public static void main(String...args){
		ShortestPalindrome test = new ShortestPalindrome();
		String inputStr = "aacecaaabb";//"aacecaaa";
		
		int length = inputStr.length();
		int lastIndex = length;
		
		for(;lastIndex > 0;lastIndex--){
			if(!test.isPalindrome(inputStr.substring(0,lastIndex))){
				break;
			}else{
				System.out.println(inputStr.substring(0,lastIndex));
			}
		}
		
		System.out.println(lastIndex);
		System.out.println("Prefix String: "+inputStr.substring(lastIndex));
	}
}