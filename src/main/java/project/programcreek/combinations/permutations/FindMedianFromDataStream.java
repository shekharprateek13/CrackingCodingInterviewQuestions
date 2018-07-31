package project.programcreek.combinations.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author shekh
 */
public class FindMedianFromDataStream {
	
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
	public static void addNumber(int x){
		maxHeap.offer(x);
		minHeap.offer(maxHeap.poll());
		
		if(maxHeap.size() < minHeap.size()){
			maxHeap.offer(minHeap.poll());
		}
	}

	public static int findMedian() {
		if(maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek())/2;
		}else {
			return maxHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			list.add(rand.nextInt(10) + 0);
		}
		
		System.out.println(list);
		for(Integer i:list){
			addNumber(i);
		}
		
		System.out.println(findMedian());
	}
}