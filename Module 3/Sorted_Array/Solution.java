import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int x = Integer.parseInt(input.nextLine());
        int y = Integer.parseInt(input.nextLine());
        String[] t = input.nextLine().split(",");
        String[] s = input.nextLine().split(",");
        int[] sort1;

        int[] sort2;
        sort2 = new int[y];

        if (t[0].equals("")) {
            sort1 = new int[0];
        } else {
            sort1 = new int[x];
            for (int i = 0; i < x; i++) {
            sort1[i] = Integer.parseInt(t[i]);
        }

        }
        for (int i = 0; i < y; i++) {
            sort2[i] = Integer.parseInt(s[i]);
        }


        // System.out.println(Arrays.toString(sort1));
        // System.out.println(Arrays.toString(sort2));
        sort(sort1, sort2);

    }
    /**
     * { function_description }.
     *
     * @param      sort1  The array 1
     * @param      sort2  The array 2
     */

    public static void sort(final int[] sort1, final int[] sort2) {
        int i = 0;
        int j = 0;
        int[] array;
        array = new int[sort1.length + sort2.length];
        for (int k = 0; k < array.length; k++) {
            if (i < sort1.length && j < sort2.length) {
                if (sort1[i] < sort2[j]) {
                    array[k] = sort1[i++];
                } else {
                    array[k] = sort2[j++];
                }
            } else if (i >= sort1.length) {
                array[k] = sort2[j++];
            } else if (j >= sort2.length) {
                array[k] = sort1[i++];
            }
        }
        System.out.println(Arrays.toString(array).replace("[", "").
            replace("]", "").replace(" ", ""));
    }

}