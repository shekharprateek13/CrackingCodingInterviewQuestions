/**
 * 
 */
package dsalgoproblems.project.programcreek.string_array;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shekh
 * Given an array of integers, find all combination of four elements in the array whose sum is equal to a given value X.
 * For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23, then your function should print “3 5 7 8” (3 + 5 + 7 + 8 = 23).
 */
public class Array4Sum {
	
	static class Position{
		int startIndex;
		int endIndex;
		
		Position(int startIndex, int endIndex){
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
	}

	public static void main(String[] args) {
		int[] input = new int[]{10,2,3,4,5,9,7,8};
		int target = 23;
		Map<Integer,List<Position>> map = new HashMap<Integer,List<Position>>();
		List<Position> list = null;
		for(int i = 0; i < input.length - 1; i++){
			for(int j = i+1; j < input.length; j++){
				int tempSum = input[i] + input[j];
				if(map.containsKey(tempSum)){
					list = map.get(tempSum);
					list.add(new Position(i,j));
				}else {
					list = new ArrayList<Position>();
					list.add(new Position(i,j));
					map.put(tempSum,list);
				}
			}
		}
		
		for(int i = 0; i < input.length - 1; i++){
			for(int j = i+1; j < input.length; j++){
				int tempSum = input[i] + input[j];
				if(map.containsKey(target - tempSum)){
					List<Position> tempList = map.get(target - tempSum);
					for(Position position: tempList){
						if(position.startIndex != i && position.endIndex != i 
								&& position.startIndex != j && position.endIndex != j){
							System.out.println("["+input[i]+","+input[j]+","+input[position.startIndex]+","
									+input[position.endIndex]+"]: "+(input[i]+input[j]+input[position.startIndex]+input[position.endIndex]));
						}
					}
				}
			}
		}
	}
}