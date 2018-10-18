package LeetCodeTopInterviewQuestions;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges{

	public static List<String> getSummary(int[] input){
		LinkedList<String> list = new LinkedList<String>();
		int i = 0,j = 1;
		while(j < input.length){
			if((input[j] - input[j - 1]) == 1){
				j++;
			}else{
				if((input[j] - input[i]) > 1 && (i == j-1)){
					list.add(""+input[i]);
				}else{
					list.add(input[i] + "->"+input[j-1]);
				}
				i = j;
				j++;
			}
		}

		if(i == (j-1)){
			list.add(""+input[i]);
		}else{
			list.add(input[i] + "->"+input[j-1]);
		}
		return list;
	}

	public static void main(String...args){
		System.out.println(getSummary(new int[]{0,1,2,4,5,7}));
	}
}