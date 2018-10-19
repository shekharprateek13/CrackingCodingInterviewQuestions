package dsalgoproblems.leetcode;

/**
 * @author shekh
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class UniquePaths {
	
	public static int recurse(int[][] cache,int m, int n, int currentRowPos, int currentColPos){
		if(currentRowPos == (m-1) && currentColPos == (n-1)){
			return 1;
		}
		
		if(currentRowPos == (m - 1)){
			return recurse(cache,m,n,currentRowPos,currentColPos+1);
		}else if(currentColPos == (n - 1)){
			return recurse(cache,m,n,currentRowPos+1,currentColPos);
		}else{
			if(cache[currentRowPos][currentColPos] > 0){
				return cache[currentRowPos][currentColPos];
			}else{
				cache[currentRowPos][currentColPos] = (recurse(cache,m,n,currentRowPos+1,currentColPos) + recurse(cache,m,n,currentRowPos,currentColPos+1)); 
				return  cache[currentRowPos][currentColPos];
			}
		}
	}

	public static int uniquePaths(int m, int n) {
		if(m == 0 || n == 0){
			return 0;
		}
		return recurse(new int[m][n],m,n,0,0);
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(2,2));

	}

}
