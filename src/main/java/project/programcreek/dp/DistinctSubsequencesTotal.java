package project.programcreek.dp;

/**
 * @author shekh
 */
public class DistinctSubsequencesTotal {

	public static int distinctStrings(String s1, String s2, int s1Length, int s2Length){
		if((s1Length == 0 && s2Length == 0) || s2Length == 0){
			return 1;
		}
		
		if(s1Length == 0){
			return 0;
		}
		
		if(s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)){
			return distinctStrings(s1, s2, s1Length - 1, s2Length - 1) 
					+ distinctStrings(s1, s2, s1Length - 1, s2Length); 
		}
		else{
			return distinctStrings(s1, s2, s1Length - 1, s2Length);
		}
	}
	
	/*public static int distinctStringsDP(String s1, String s2, int s1Length, int s2Length){
		int[][] cache =
	}*/
	
	public static void main(String[] args) {
		String s1 = "GeeksforGeeks";
		String s2 = "Gks";
		System.out.println(distinctStrings(s1,s2,s1.length(),s2.length()));
	}
}