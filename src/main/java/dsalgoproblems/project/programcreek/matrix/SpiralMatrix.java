package dsalgoproblems.project.programcreek.matrix;

/**
 * @author shekh
 */
public class SpiralMatrix {

	public static void printSpiralMatrix(int[][] M, int rowLength, int colLength){
		
		//Print top row......:
		for(int i = 0; i < colLength; i++){
			System.out.print(M[0][i]+" ");
		}

		//Print last column......:
		for(int i = 1; i < rowLength; i++){
			System.out.print(M[i][M.length - 1]+" ");
		}

		//Print bottom row.......:
		for(int i = colLength - 2; i >= 0; i--){
			System.out.print(M[rowLength - 1][i]+" ");
		}

		//Print first column.......:
		for(int i = rowLength - 2; i > 0; i--){
			System.out.print(M[i][0]+" ");
		}
		
		if(rowLength > 2 && colLength > 2){
			int[][] temp = new int[rowLength - 2][colLength - 2];
			for(int i = 0; i < temp.length;i++){
				for(int j = 0; j < temp[0].length;j++){
					temp[i][j] = M[i+1][j+1];
				}
			}
			
			printSpiralMatrix(temp, rowLength - 2, colLength - 2);
		}
		


	}

	public static void main(String[] args) {
		printSpiralMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}},4,5);

	}

}
