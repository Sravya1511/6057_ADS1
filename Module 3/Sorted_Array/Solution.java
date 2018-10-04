import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {

    }
    /**
     * { Reads input }.
     * Creates object for sort class.
     * calls sort method of sort class
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
        Sort sort = new Sort();
        sort.sort(sort1, sort2);

    }
}
class Sort {
    /**
     * { sort method sorts two sorted arrays}.
     *
     * @param      sort1  The array 1 of type integer.
     * @param      sort2  The array 2 of type integer.
     */

    public  void sort(final int[] sort1, final int[] sort2) {
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


