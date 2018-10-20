package dsalgoproblems.project.programcreek.combinations.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class Permutations1 {

	public static void getPermutations(List<Integer> input, List<Integer> temp, List<List<Integer>> completeList){
		if(temp.size() == input.size()){
			completeList.add(new ArrayList<Integer>(temp));
		}
		
		for(int i = 0; i < input.size(); i++){
			temp.add(input.get(i));
			getPermutations(input, temp, completeList);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args){
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		List<List<Integer>> completeList = new ArrayList<List<Integer>>();
		getPermutations(input, new ArrayList<Integer>(), completeList);
		for(List<Integer> temp: completeList){
			System.out.println(temp);
		}
	}
}