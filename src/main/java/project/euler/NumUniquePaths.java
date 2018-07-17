package project.euler;

/**
 * @author shekh
 */
public class NumUniquePaths {

	public NumUniquePaths() {
		// TODO Auto-generated constructor stub
	}

	public static int getUniquePathsCount(int[][] M, int rowLength, int colLength, int currentRowPos,int currentColPos){
		if(currentRowPos == rowLength - 1 && currentColPos == colLength - 1){
			return 1;
		}

		if(currentRowPos == rowLength - 1){
			return getUniquePathsCount(M, rowLength, colLength, currentRowPos, currentColPos + 1);
		}else if (currentColPos == colLength - 1){
			return getUniquePathsCount(M, rowLength, colLength, currentRowPos + 1, currentColPos);
		}else{
			return  getUniquePathsCount(M, rowLength, colLength, currentRowPos + 1, currentColPos) 
					+ getUniquePathsCount(M, rowLength, colLength, currentRowPos, currentColPos + 1);
		}
	}

	public static int getUniquePathsCount(int m,int n){
		if(m == 1 || n == 1){
			return 1;
		}
		return  getUniquePathsCount(m - 1,n) + getUniquePathsCount(m, n - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] M = new int[][]{
			{1,2,3},
			{3,4,3},
			{3,4,3}
		};

		System.out.println(getUniquePathsCount(M, M.length, M[0].length, 0, 0));
		System.out.println(getUniquePathsCount(2, 2));
	}

}
