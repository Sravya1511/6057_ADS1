import java.util.Scanner;
import java.util.Arrays;
/**
 * input reading.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { this method reads input and creates object for three sum class }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * {input reading }
         */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        ThreeSum three = new ThreeSum();
        three.threesum(array, n);
    }
}
/**
 * Class for three sum.
 * This class calculates sum of three numbers until it is zero.
 * The complexity of this methid is N^2log(N).
 * The two for loops will give N^2.
 * The binary search gives log(N).
 */
class ThreeSum {
     /**
     * {three sum function.
     *
     * @param      array  The array
     * @param      n      { integer type }
     */

    public void threesum(final int[] array, final int n) {
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

