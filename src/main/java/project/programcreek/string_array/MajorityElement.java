/**
 * 
 */
package project.programcreek.string_array;

/**
 * @author shekh
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] x = new int[]{4,7,4,4,7,4,4,9,4,3};
		int majorityElementIndex = 0;
		int count = 0;
		
		for(int i = 0; i < x.length; i++){
			if(count == 0){
				majorityElementIndex = i;
				count = 1;
			}else if(x[i] == x[majorityElementIndex]){
				count++;
			}else{
				count--;
			}
		}
		
		if(majorityElementIndex == 0){
			System.out.println("No Majority Element!!!");
		}else{
			count = 0;
			for(int i = 0; i < x.length;i++){
				if(x[i] == x[majorityElementIndex]){
					count++;
				}
			}
		}
		if(count > x.length/2){
			System.out.println(x[majorityElementIndex]);
		}
	}
}
