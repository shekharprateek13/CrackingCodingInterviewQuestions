package LeetCodeTopInterviewQuestions;
/**
 * @author shekh
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1. 
 */
public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		   if((gas.length != cost.length) || (gas.length == 0) || (cost.length == 0)){
	            return -1;
	        }
	        
	        int totalSum = 0;
	        int startIndex = 0;
	        for(int i = 0; i < gas.length; i++){
	            totalSum += gas[i] - cost[i];
	            if(totalSum < 0){
	                startIndex = i+1;
	                totalSum = 0;
	            }
	        }
	        if(startIndex >= gas.length){
	        	return -1;
	        }else{
	        	return startIndex;
	        }
	}

	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[]{5,4},new int[]{5,6}));
	}
}
