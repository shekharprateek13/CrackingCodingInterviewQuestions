package project.programcreek.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DecodeWays{

	/*
	 * Trailing 0s in n! = Count of 5s in prime factors of n! = floor(n/5) + floor(n/25) + floor(n/125) + ....
	 */
	public static int findTrailingZeros(int n) {
		//Initialize result...................................
		int count = 0;

		// Keep dividing n by powers of 5 and update count....
		for (int i = 5; n / i >= 1; i *= 5)
			count += n / i;

		return count;
	}

	public static String convertToTitle(int n) {
		if(n <= 0){
			throw new IllegalArgumentException("Input is not valid!");
		}

		StringBuilder sb = new StringBuilder();

		while(n > 0){
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			sb.append(ch);
		}

		sb.reverse();
		return sb.toString();
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";

		String result = "";

		// is result is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}

		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);

		// quotient 
		long res = num / den;
		result += String.valueOf(res);

		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;

		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder); 
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
		}

		return result;
	}
	
	public static int nthUglyNumber(int n) {
	    if(n <= 0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	 
	    int i = 0;
	    int j = 0;
	    int k = 0;
	 
	    while(list.size() < n){
	        int m2 = list.get(i)*2;
	        int m3 = list.get(j)*3;
	        int m5 = list.get(k)*5;
	 
	        int min = Math.min(m2, Math.min(m3, m5));
	        list.add(min);
	 
	        if(min==m2)
	            i++;
	 
	        if(min==m3)
	            j++;
	 
	        if(min==m5)
	            k++;
	    }
	    return list.get(list.size()-1);
	}

	public static int nthSuperUglyNumber(int n, int[] primes) {
	    int[] times = new int[primes.length];
	    int[] result = new int[n];
	    result[0] = 1; // first is 1
	 
	    for (int i = 1; i < n; i++) {
	        int min = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++) {
	            min = Math.min(min, primes[j] * result[times[j]]);
	        }
	 
	        result[i] = min;
	 
	        for (int j = 0; j < times.length; j++) {
	            if (result[times[j]] * primes[j] == min){
	                times[j]++;
	            }
	        }
	    }
	    return result[n - 1];
	}

	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	    List<int[]> result = new ArrayList<int[]>();
	 
	    k = Math.min(k, nums1.length*nums2.length);
	 
	    if(k==0)
	        return result;
	 
	    int[] idx = new int[nums1.length];
	 
	    while(k>0) {
	        int min = Integer.MAX_VALUE;
	        int t=0;
	        for(int i = 0; i < nums1.length; i++) {
	            if(idx[i] < nums2.length && nums1[i] + nums2[idx[i]] < min) {
	                t=i;
	                min = nums1[i]+nums2[idx[i]];
	            }
	        }
	 
	        int[] arr = {nums1[t], nums2[idx[t]]};    
	        result.add(arr);
	 
	        idx[t]++;
	 
	        k--;
	    }
	 
	    return result;
	}
	
	public static void main(String...args) {
		int[] nums1 = new int[]{1,3,11};
		int[] nums2 = new int[]{2,4,8};
		System.out.println(kSmallestPairs(nums1,nums2,3));
	}
}