/**
 * 
 */
package LeetCodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author shekh
 *
 */
public class Coins {

	public static int recurse(int n, int sum){
		if(n <= 0)
			return sum;
		/*else if(n == 1)
			return recurse(n - 1, sum+1);
		else if(n == 5)
			return recurse(n - 5,sum+1);
		else if(n==10)
			return recurse(n - 10,sum+1);
		else if(n==25)
			return recurse(n - 25,sum+1);*/
		else{
			return recurse(n - 25,sum+1)+recurse(n - 10,sum+1)+recurse(n - 5,sum+1)+recurse(n - 1,sum+1);
		}
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.addAll((Collection<? extends List<Integer>>) new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            
            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

	public static void main(String[] args) {
		/*System.out.println(recurse(5,0));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println(list.get(1));*/
		List<List<Integer>> list = generate(3);
		for(List<Integer> temp:list){
			System.out.println(temp);
		}
	}
}