package dsalgoproblems.project.programcreek.dp;

/**
 * @author shekh
 */
public class DistinctSubsequencesTotal {

	public static int distinctStrings(String s1, String s2, int s1Length, int s2Length) {
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

	public static int numDistincts(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];
		for(int i = 0; i < S.length(); i++)
			table[i][0] = 1;

		for(int i = 1; i <= S.length(); i++){
			for(int j = 1; j <= T.length(); j++) {
				if(S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				}else{
					table[i][j] += table[i - 1][j];
				}
			}
		}
		return table[S.length()][T.length()];
	}

	public static void main(String[] args) {
		String s1 = "GeeksforGeeks";
		String s2 = "Gks";
		System.out.println(distinctStrings(s1,s2,s1.length(),s2.length()));
		System.out.println(numDistincts(s1,s2));
	}
}