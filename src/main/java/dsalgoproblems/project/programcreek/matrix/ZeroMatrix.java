package dsalgoproblems.project.programcreek.matrix;

/**
 * @author shekh
 */
public class ZeroMatrix {
	
	public static void setMatrixZeroes(int[][] M){
		boolean isZeroRow = false;
		boolean isZeroColumn = false;
		
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j < M[0].length; j++){
				if(i == 0 && M[0][j] == 0){
					isZeroRow = true;
				}
				
				if(j == 0 && M[i][0] == 0){
					isZeroColumn = true;
				}
				
				if(M[i][j] == 0){
					M[0][j] = 0;
					M[i][0] = 0;
				}
			}
		}
		
		for(int i = 1; i < M.length; i++){
			for(int j = 1; j < M[0].length;j++){
				if(M[0][j] == 0 || M[i][0] == 0){
					M[i][j] = 0;
				}
			}
		}
		
		if(isZeroRow){
			for(int j = 0; j < M[0].length;j++){
					M[0][j] = 0;
			}
		}
		
		if(isZeroColumn){
			for(int j = 0; j < M.length;j++){
					M[j][0] = 0;
			}
		}
		
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j < M[0].length;j++){
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		setMatrixZeroes(new int[][]{{1,1,1,0},{1,1,1,0},{1,1,0,0},{1,0,0,0}});
		System.out.println();
		System.out.println();
		setMatrixZeroes(new int[][]{{0,1,1,0},{1,1,0,1},{1,1,1,1}});

	}

}
