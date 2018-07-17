/**
 * 
 */
package LeetCodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class PowerSet {

	public static void recurse(List<Integer> list, List<Integer> tempList,List<List<Integer>> result,int start){
		result.add(new ArrayList<Integer>(tempList));
		for(int i = start; i < list.size(); i++){
			tempList.add(list.get(i));
			recurse(list,tempList,result,i+1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		recurse(list,new ArrayList<Integer>(),result,0);
		System.out.println(result);
	}
}