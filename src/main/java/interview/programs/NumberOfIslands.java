/**
 * 
 */
package interview.programs;

/**
 * @author shekh
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is 
 * formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all 
 * surrounded by water.
 */
public class NumberOfIslands {
	
	public static int dfs(int[][] M, int currentRow, int currentCol){
		
		if(currentRow < 0 || currentRow == M.length){
			return 0;
		}
		
		if(currentCol < 0 || currentCol == M[0].length){
			return 0;
		}
		
		if(M[currentRow][currentCol] == 1){
			M[currentRow][currentCol] = 0;
			return 0;
		}else{
			dfs(M,currentRow+1,currentCol);
			dfs(M,currentRow-1,currentCol);
			dfs(M,currentRow,currentCol+1);
			dfs(M,currentRow,currentCol-1);
			return 1;
		}
		
	}
	
	public static void displayMatrix(int[][] M){
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j < M[0].length; j++){
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] M = new int[][]{
			{1,1,1,1,0},
			{1,1,1,1,0},
			{1,1,0,0,0},
			{1,1,0,0,0}
		};
		
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j < M[0].length; j++){
				if(M[i][j] == 1){
					dfs(M,i,j);
					displayMatrix(M);
					break;
				}
			}
		}
	}
}