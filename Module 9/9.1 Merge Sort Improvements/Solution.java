import java.util.*;
/**
 * Class for solution.
 * class reads input.The object is created for merge sort
 * The method sort is called.
 */
class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {

    }
    /**
     * reads input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
        String [] token = input.nextLine().split(",");
        int size = token.length;
        Comparable[] aux = new Comparable[size];
        MergeSort merge = new MergeSort();
        merge.sort(token);
        System.out.println(Arrays.toString(token));
        System.out.println();
        }
    }
}
