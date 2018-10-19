package dsalgoproblems.programcreek.combinations.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class PermutationSequence {

	static int count = 0;
	public static List<Integer> getPermutationSequence(List<Integer> input, List<Integer> temp, int k){
		if(temp.size() == input.size()){
			count++;
			if(count == k){
				return temp;
			}else{
				return null;
			}
		}
		
		for(int i = 0; i < input.size(); i++){
			if(temp.contains(input.get(i)))continue;
			temp.add(input.get(i));
			if(getPermutationSequence(input, temp, k) != null){
				return temp;
			}else{
				temp.remove(temp.size() - 1);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		System.out.println(getPermutationSequence(input,new ArrayList<Integer>(),6));
	}
}