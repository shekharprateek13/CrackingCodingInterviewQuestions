package dsalgoproblems.programcreek.combinations.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class FactorCombinations {
	
	public static List<List<Integer>> getFactorCombinations(int n){
		List<List<Integer>> completeList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		recurse(completeList,list,n,2,1);
		return null;
	}
	
	
	public static void recurse(List<List<Integer>> completeList, List<Integer> list, int input, int start, int product){
		if(start > input || product > input){
			return;
		}
		
		if(product == input){
			completeList.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i = start; i < input; i++){
			if(i*product > input){
				break;
			}
			
			if(input%i == 0){
				list.add(i);
				recurse(completeList,list,input,start+1,i*product);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		
	}
}