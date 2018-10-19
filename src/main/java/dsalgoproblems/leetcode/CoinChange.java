package dsalgoproblems.leetcode;

/**
 * @author shekh
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number 
 * of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, 
 * return -1.
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1. 
 */
public class CoinChange {

	public static int recurse(int[] coins, int[] cache,int amount,int totalCoins){
		if(amount == 0){
			return 0;
		}

		if(cache[amount] > -1){
			recurse(coins,cache,amount - cache[amount],totalCoins);
			totalCoins = totalCoins + 1;
		}else{
			int minValue = amount;
			for(int i = 0; i < coins.length; i++){
				//if(minValue > (amount - coins[i])){
				//	minValue = (amount - coins[i]);
				//}
				

			}
			cache[amount] = minValue + 1;
		}
		return 0;
	}

	public int coinChange(int[] coins, int amount) {
		return 0;
	}

	public static void main(String[] args) {
//		Collections.rever
	}
}