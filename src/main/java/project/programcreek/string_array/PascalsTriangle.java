package project.programcreek.string_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shekh
 */
public class PascalsTriangle {

	public static List<List<Integer>> generatePascalsTriangle(int n){
		int i = 1;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		list.add(pre);
		for(i = 1; i < n; i++){
			pre = list.get(i - 1);
			List<Integer> tmpList = new ArrayList<Integer>();
			tmpList.add(1);
			for(int j = 1; j <= pre.size() - 1; j++){
				tmpList.add(pre.get(j) + pre.get(j-1));
			}
			tmpList.add(1);
			list.add(i, tmpList);
		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> list = generatePascalsTriangle(10);
		for(List l:list){
			System.out.println(l);
		}
	}
}