package interview.programs;

import java.util.Scanner;

public class ArrayLeftRotation {
	/*
	 * With using a temporary array
	 */
	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		int[] temp = new int[n];
		
		for(int i = 0;i < k;i++){
			temp[n - k + i] = a[i];
		}
		
		for(int i = k,j = 0;i < n; i++,j++){
			temp[j] = a[k];
		}
		
		return temp; 
	}
	
	/*
	 * Without using any other data structure
	 */
	public static int[] arrayLeftRotation(int[] a,int k){
		int n = a.length;
		for(int i = 0;i < k;i++){
			for(int j = 0;j < n - 1;j++){
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
		return a;
	}

	public static void main(String...args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}

		int[] output = new int[n];
		output = arrayLeftRotation(a, k);
		for(int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

		System.out.println();
	}
}
