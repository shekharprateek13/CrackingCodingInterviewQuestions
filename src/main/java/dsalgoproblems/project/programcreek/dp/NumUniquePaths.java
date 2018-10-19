package dsalgoproblems.project.programcreek.dp;

/**
 * @author shekh
 */
public class NumUniquePaths {

	public static int getTotalUniquePathsDP(int[][] mat, int m, int n) {
		if(m == 0 || n == 0) {
			mat[m][n] = 1;
			return 1;
		}
		
		if(mat[m][n] != 1) {
			return mat[m][n];
		}
		
		mat[m][n] = getTotalUniquePathsDP(mat, m - 1, n) +  getTotalUniquePathsDP(mat, m, n - 1);
		return mat[m][n];
	}
	
	public static int getTotalUniquePaths(int rows,int col){
		int[][] dp = new int[rows][col];
		
		for(int i = 0; i < rows; i++){
			dp[i][0] = 1;
		}
		
		for(int i = 0; i < col; i++){
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < rows; i++){
			for(int j = 1; j < col; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < col; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[rows - 1][col - 1];
	}
	
	
	public static void main(String[] args) {
		int[][] mat = new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		System.out.println(getTotalUniquePathsDP(mat,mat.length - 1,mat[0].length - 1));
		System.out.println(getTotalUniquePaths(mat.length,mat[0].length));

	}
}