package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum. 
 */
public class MinimumPathSum {

	public static int recurse(int[][] M,int[][] cache, int i, int j, int rowEnd, int colEnd){
		if(i == rowEnd && j == colEnd){
			return M[rowEnd][colEnd];
		}

		if(i == rowEnd){
			return (M[i][j] + recurse(M,cache,i,j+1,rowEnd,colEnd));
		}else if(j == colEnd){
			return (M[i][j] + recurse(M,cache,i+1,j,rowEnd,colEnd));
		}else{
			if(cache[i][j] > 0){
				return cache[i][j];
			}else{
				cache[i][j] = Math.min(M[i][j] + recurse(M,cache,i+1,j,rowEnd,colEnd),M[i][j] + recurse(M,cache,i,j+1,rowEnd,colEnd));
				return cache[i][j];
			}
		}
	}

	public static void main(String[] args){
		int[][] M = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(recurse(M,new int[M.length][M[0].length],0,0,M.length-1,M[0].length-1));

	}
}