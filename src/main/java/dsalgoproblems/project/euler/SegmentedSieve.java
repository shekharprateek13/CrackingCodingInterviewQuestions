package dsalgoproblems.project.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 * Sieve of Eratosthenes Problem in Segmentation....
 */
public class SegmentedSieve {

	public SegmentedSieve() {}
	
	public static List<Integer> SieveOfEratosthenes(int n){
		List<Integer> primesList = new ArrayList<Integer>();
		primesList.add(2);
		boolean[] arr = new boolean[n+1];
		
		for(int i = 2;i < arr.length;i++){
			arr[i] = true;
		}
		
		for(int i = 2; i < n; i++){
			if(arr[i] == false)
				continue;
			
			for(int count = 2,j = i * count; j <= n;count++){
				arr[j] = false;
				j = count*i;
			}
		}
		
		for(int i = 0; i < arr.length;i++){
			if(arr[i] == true)
				primesList.add(i);
		}
		
		return primesList;
	}
	
	public static List<Integer> SegmentedSieveOfEratosthenes(int n,int bucketSize){
		int count = n/bucketSize;
		List<Integer> primesList = new ArrayList<Integer>();
		
		for(int i = 0; i < count; i++){
			int[] tempArr = new int[bucketSize+1];
			
		}
		
		return null;
	}

	public static void main(String[] args) {
		SegmentedSieve.SieveOfEratosthenes(50);
	}
}