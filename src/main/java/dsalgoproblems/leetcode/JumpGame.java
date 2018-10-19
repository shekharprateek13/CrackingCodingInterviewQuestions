/**
 * 
 */
package dsalgoproblems.leetcode;

import java.util.concurrent.Future;

/**
 * @author shekh
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false. 
 */
public class JumpGame{

	public static boolean canJump(int[] nums){
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			if(i > max){
				return false;
			}
			max = Math.max(nums[i]+i,max);
		}
		return true;
	}
	
	public static int minJumpCount(int[] nums) {
		int max = 0;
		int minJumpCount = 0;
		int minSteps = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i > minJumpCount){
				minSteps++;
				minJumpCount = max;
			}
			
			max = Math.max(nums[i]+i,max);
		}
		return minSteps;
	}

	public static void main(String[] args){
		int[] nums = new int[]{2,3,1,1,4};
		System.out.println(JumpGame.canJump(nums));
		System.out.println(JumpGame.minJumpCount(nums));
		Future f = null;
//		f.
	}
}