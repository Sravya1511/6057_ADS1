import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] array;
		array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		Arrays.sort(array);
		threesum(array, n);
	}

	public static void threesum(final int[] array, final int n) {
		// System.out.println(Arrays.toString(array));
        int count = 0;
		for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(array, -(array[i] + array[j]));
                if (k > j) {
                	count++;
                }
            }
        }

		System.out.println(count);
	}
}