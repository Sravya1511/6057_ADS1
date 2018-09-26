import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long [] array;
		array = new long[n];
		for(int i= 0; i<n; i++) {
			array[i] = input.nextInt();
		}
		Arrays.sort(array);
		threesum(array, n);
	}

	public static void threesum(long[] array, int n) {
		// System.out.println(Arrays.toString(array));

		int count = 0;
		for(int i = 0; i<n; i+=2) {
			// System.out.println("a");
			for(int j=i+2; j<n;j++) {
				if (array[i]+array[i+1]+array[j] == 0) {
					count++;
				}
			}

		}
		System.out.println(count);
	}
}