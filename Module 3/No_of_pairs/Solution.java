import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] array;
		array = new int[n];
		for(int i= 0; i<n; i++) {
			array[i] = input.nextInt();
		}
		arraypairs(array, n);
		Arrays.sort(array);
		arraysort(array, n);
	}

	public static void arraypairs(int[] array, int n) {
		int iterations = 0;
		int pairs = 0;
		for(int i = 0; i<n-1; i++) {
			for(int j = i+1; j<n; j++) {
				if(array[i] == array[j]) {
					System.out.println(array[i]+", "+array[j]);
					pairs++;
				}
				iterations++;
			}
		}
		System.out.println("number of pairs "+pairs);
		System.out.println("number of iterations "+iterations);
	}

	public static void arraysort(int[] array, int n){
		int total = 0;
		int pair = 1;
		for(int i = 0; i<n; i++) {
			if(i < n-1 && array[i] == array[i+1]) {
				pair++;
			}
			else {
				if(pair >1) {
					total += pair*(pair-1)/2;
				}
				pair = 1;
			}
		}
		System.out.println("number of pairs "+total);
		// System.out.println("number of iterations "+iterations);
	}

	// public static void arraysort(int[] array, int n){
	// 	int iterations = 0;
	// 	int pairs = 0;
	// 	for(int i = 0; i<n-1; i++) {
	// 		int j = i+1;
 //            while(j<n) {
 //            	if(array[i] == array[j]) {
	// 			System.out.println(array[i]+", "+array[j]);
	// 			pairs++;
	// 			// break;
 //                }
 //                j++;
 //                iterations++;
	// 		}

	// 	}
	// 	System.out.println("number of pairs "+pairs);
	// 	System.out.println("number of iterations "+iterations);
	// }
	//

}