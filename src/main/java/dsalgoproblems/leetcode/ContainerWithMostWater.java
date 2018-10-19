package dsalgoproblems.leetcode;

/**
 * @author shekh
 */

public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int area = 0;
		while(i < j){
			area = Math.max(area,(j - i)*Math.min(height[i],height[j]));
			if(height[i] < height[j]){
				i++;
			}else{
				j--;
			}
		}
		return area;
	}

	public static void main(String[] args) {
		int[] height = new int[]{3, 1, 2, 4, 5};
		System.out.println(maxArea(height));
	}
}