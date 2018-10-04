import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for quick sort.
 * The quick sort is the recursive sort.
 * The elements are sort based on the pivot element.
 * Time complexity is O(NlogN).
 */
class QuickSort {

    QuickSort() {

    }
    /**
     * method for sort.
     * overloaded method.
     * Time complexity is O(NlogN).
     *
     * @param      a       { array of type comparable }
     * @param      cutOff  The cut off of type integer.
     */

    public static void sort(final Comparable[] a, final int cutOff) {
        sort(a, 0, a.length - 1, cutOff);
    }
    /**
     * sorts the array.
     * Overloaded method.
     * If the array size is less than cutoff value, insertion sort is called.
     * Time complexity is O(NlogN).
     *
     *
     * @param      a       { array of comparable type }
     * @param      lo      The lower of int type.
     * @param      hi      The higher of int type.
     * @param      cutOff  The cut off of int type.
     */
    private static void sort(final Comparable[] a, final int lo,
        final int hi, final int cutOff) {
        Insertion insertion  = new Insertion();
        if (hi <= lo + cutOff - 1) {
            insertion.insertionSort(a, lo, hi);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(a, lo, hi);
        System.out.println(Arrays.toString(a));
        sort(a, lo, k - 1, cutOff);
        sort(a, k + 1, hi, cutOff);
    }

    /**
     * partition method.
     * Time complexity is O(NlogN).
     *
     *
     * @param      arr   The arr of type comparable.
     * @param      low   The low of int type.
     * @param      high  The high of int type.
     *
     * @return     { returns partition index of int type }
     */

    public static int partition(final Comparable[] arr,
     final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(arr[low], arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
         exch(arr, low, j);
        // System.out.println(toString(arr));
        return j;
    }
    /**
     * compares two elements.
     * Time complexity is O(1).
     *
     * @param      v     { comparable type }
     * @param      w     { comparable type
     *
     * @return     { returns true or false}
     */

    private static boolean less(final Comparable v, final Comparable w) {
        if (v == w) {
        return false;
        }   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    /**
     * exchanges two elements
     * Time complexity is O(1).
     *
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private static void exch(final Object[] a, final int i, final int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * Determines if sorted. or not.
     * Time complexity is O(N).
     *
     *
     * @param      a     { array of comparable type }
     * @param      low   The low of int type.
     * @param      high  The high of int type.
     *
     * @return     True if sorted, False otherwise.
     */

    public static boolean isSorted(final Comparable[] a,
     final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
/**
 * class for solution.
 * The object for quick sort is created.
 * The sort method is called.
  */

public final class Solution {
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
        /**
         * input reading
         * Time complexity is O(N).
         */
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            QuickSort quick = new QuickSort();
            int cutOff = Integer.parseInt(input.nextLine());
            String[] array = input.nextLine().split(" ");
            if (array[0].equals("")) {
                System.out.println("[]");
            } else {
            quick.sort(array, cutOff);
            System.out.println(Arrays.toString(array));
            }

        }
    }
}

/**
 * Class for insertion sort.
 * elements are sorted.
 */

class Insertion {
    /**
     * insertion sort sorts the elements in array.
     * Time complexity is O(n^2).
     *
     * @param      a     {Comparable type }
     * @param      low   The lower of int type
     * @param      high    The higher of int type.
     */
    public void insertionSort(final Comparable[] a,
        final int low, final int high) {
        // System.out.println("insertionSort called");
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }

    }
   /**
    * exchanges or swaps two numbers
    * Time complexity is O(1).
    *
    * @param      a     { comparable type }
    * @param      i     { index of first element }
    * @param      j     { index of second element }
    */
    public void exchange(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * checks if the number is less or not
     * Time complexity is O(1).
     *
     * @param      a     { comparable type }
     * @param      b     { comparable type }
     *
     * @return     { returns boolean value }
     */

     public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }

}
