package project.programcreek.string_array;

import java.util.LinkedList;

/**
 * @author shekh
 */
public class SlidingWindowMaximum {
	
	public static void getMaximumElement(int[] nums, int windowSize){
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int i = 0;
		for(; i < windowSize; i++){
			while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
				deque.removeLast();
			}
			deque.addLast(i);
		}
		
		for(;i < nums.length;i++){
			System.out.print(nums[deque.peek()]+" ");
			while(!deque.isEmpty() && deque.peek() == i - windowSize){
				deque.remove();
			}
			
			while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
				deque.removeLast();
			}
			
			deque.addLast(i);
		}
		System.out.print(nums[deque.peek()]);
	}

	public static void main(String[] args) {
		getMaximumElement(new int[]{1,2,3,1,4,5,2,3,6},3);
	}
}