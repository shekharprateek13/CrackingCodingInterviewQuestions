package project.programcreek.matrix;

/**
 * @author shekh
 */
public class RotateAMatrix {
	
	
	public static void displayMatrix(int[][] nums){
		System.out.println();
		System.out.println();
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums[0].length; j++){
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void rotateMatrix(int[][] M){
		displayMatrix(M);
		int[][] N = new int[M[0].length][M.length];
		
		for(int i = 0; i < M.length;i++){
			int[] row = M[i];
			for(int j = 0; j < row.length; j++){
				N[j][N[0].length - 1 - i] = row[j];
			}
		}
		displayMatrix(N);
	}

	public static void main(String[] args) {
		rotateMatrix(new int[][]{{1,2,3},{4,5,6}});
	}
}