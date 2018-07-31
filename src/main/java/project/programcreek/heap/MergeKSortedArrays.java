package project.programcreek.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author shekh
 */
public class MergeKSortedArrays {
	
	static class ArrayContainer implements Comparable<ArrayContainer>{
		List<Integer> arr;
		int index;
		
		public ArrayContainer() {}
		
		public ArrayContainer(List<Integer> array, int index) {
			this.arr = array;
			this.index = index;
		}

		@Override
		public int compareTo(ArrayContainer o) {
			return this.arr.get(this.index) - o.arr.get(o.index); 
		}
	}

	public static int[] mergeKSortedArrays(List<List<Integer>> nums,int numArrays){
		if(numArrays == 0 || nums == null)
			return null;
		
		PriorityQueue<ArrayContainer> priorityQueue = new PriorityQueue<ArrayContainer>();
		int total = 0;
		
		for(int i = 0; i < numArrays; i++){
			priorityQueue.add(new ArrayContainer(nums.get(i),0));
			total += nums.get(i).size();
		}
		
		int[] result = new int[total];
		int i = 0;
		while(!priorityQueue.isEmpty()){
			ArrayContainer temp = priorityQueue.poll();
			result[i++] = temp.arr.get(temp.index);
			
			if(temp.index < temp.arr.size() - 1){
				priorityQueue.add(new ArrayContainer(temp.arr,temp.index+1));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] array = new int[][]{
			{1,3,5,7},
			{2,6},
			{0,9,10,11}
		};
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(3);
		temp.add(5);
		temp.add(7);
		list.add(temp);
		
		temp = new ArrayList<Integer>();
		temp.add(2);
		temp.add(6);
		list.add(temp);
		
		temp = new ArrayList<Integer>();
		temp.add(0);
		temp.add(9);
		temp.add(10);
		temp.add(11);
		list.add(temp);
		
		System.out.println(list);
		int[] result = mergeKSortedArrays(list,3);
		for(int i:result){
			System.out.println(i);
		}
	}
}