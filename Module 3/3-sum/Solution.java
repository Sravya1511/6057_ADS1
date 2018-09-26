import java.util.Scanner;
import java.util.Arrays;
/**
 * input reading
 */
final class Solution {
	private Solution() {

	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		/**
		 * { var_description }
		 */
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array;
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		Arrays.sort(array);
		threesum(array, n);
	}
	/**
	 * {three sum function
	 *
	 * @param      array  The array
	 * @param      n      { parameter_description }
	 */

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