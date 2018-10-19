/**
 * 
 */
package dsalgoproblems.project.programcreek.string_array;

/**
 * @author shekh
 */
public class ReverseString {
	
	public static void reverse(char[] c,int start, int end){
		char temp;
		while(start < end){
			temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		String s = "the sky is blue";
		char[] c = s.toCharArray();
		int j = 0, i = 0;;
		for(i = 0; i < s.length(); i++){
			if(c[i] == ' '){
				reverse(c,j,i-1);
				j = i+1;
			}
		}
		reverse(c,j,s.length() - 1);
		
		System.out.println(String.valueOf(c));
		reverse(c,0,c.length-1);
//		System.out.println(String.valueOf(c));
	}

}
