package project.programcreek.combinations.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class Permutations2 {

	public static void getPermutations(List<Integer> input, List<Integer> temp, List<List<Integer>> completeList, int start){
		if(temp.size() == input.size()){
			completeList.add(new ArrayList<Integer>(temp));
		}
		
		for(int i = start; i < input.size(); i++){
			temp.add(input.get(i));
			getPermutations(input, temp, completeList, start+1);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args){
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(1);
		input.add(2);
		List<List<Integer>> completeList = new ArrayList<List<Integer>>();
		getPermutations(input, new ArrayList<Integer>(), completeList, 0);
		for(List<Integer> temp: completeList){
			System.out.println(temp);
		}
	}
}