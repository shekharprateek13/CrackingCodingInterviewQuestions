package LeetCodeTopInterviewQuestions;

/**
 * @author shekh
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 * 	[1,   3,  5,  7],
 * 	[10, 11, 16, 20],
 * 	[23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Search2DMatrix {
	
	public static int binarySearch(int[] nums,int left,int right,int target){
		int targetIndex = -1;
		int mid = (left+right)/2;

		if(left > right){
			return -1;
		}

		if(nums[mid] == target){
			return mid;
		}

		if(nums[mid] < target){
			targetIndex = binarySearch(nums, mid + 1, right, target);
		}else if(nums[mid] > target){
			targetIndex = binarySearch(nums, left, mid - 1, target);
		}
		return targetIndex;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		boolean foundElement = false;
		int rowIndex = -1;
		for(int i = 0; i < matrix.length; i++){
			if(matrix[i][0] <= target){
				rowIndex = i; 
			}else{
				break;
			}
		}
		
		if(rowIndex == -1){
			return false;
		}else{
			foundElement = (binarySearch(matrix[rowIndex],0,matrix[0].length - 1,target) > -1)?true:false;
		}
		return foundElement;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{1}
		};
		
		boolean foundElement = searchMatrix(matrix,1);
		System.out.println(foundElement);
	}
}