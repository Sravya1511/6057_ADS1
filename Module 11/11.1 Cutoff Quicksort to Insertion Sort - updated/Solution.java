import java.util.Scanner;
import java.util.Arrays;
class QuickSort {

     QuickSort() { }


    public static void sort(Comparable[] a, int cutOff) {
        sort(a, 0, a.length - 1, cutOff);
    }

    private static void sort(Comparable[] a, int lo, int hi, int cutOff) {
        Insertion insertion  = new Insertion();
        if (hi <= lo + cutOff - 1) {
            insertion.insertionSort(a, lo, hi);
            return;
        }
        int k = partition(a, lo, hi);
        System.out.println(Arrays.toString(a));
        sort(a, lo, k - 1, cutOff);
        sort(a, k + 1, hi, cutOff);

        // if (hi <= lo) return;
        // Insertion insertion  = new Insertion();
        //  if(isSorted(a, lo, hi))
        //     return;
        // int j = partition(a, lo, hi);
        //  // if(isSorted(a, lo, hi))
        //  //    return;

        // sort(a, lo, j-1);
        //  // if(isSorted(a, lo, j-1))
        //  //    return;
        // if(j-lo-1 < 3) {
        //     insertion.insertionSort(a, lo, j);
        // }
        // sort(a, j+1, hi);
        //  // if(isSorted(a, j+1, hi))
        //  //    return;
        // if(hi-j+1 < 3) {
        //     insertion.insertionSort(a, j+1, hi);
        // }


    }

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

    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++)
            if (less(a[i], a[i-1])) {
                return false;
            }
        return true;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for(int i = 0; i<n*2; i++) {
            QuickSort quick = new QuickSort();
            int cutOff = Integer.parseInt(input.nextLine());
            String[] array = input.nextLine().split(" ");
            quick.sort(array, cutOff);
            System.out.println(Arrays.toString(array));
        }
    }
}

class Insertion {
    /**
     * insertion sort sorts the elements in array.
     * Time complexity is O(n^2).
     *
     * @param      a     {Comparable type }
     * @param      lo    The lower of int type
     * @param      hi    The higher of int type.
     */
    public void insertionSort(Comparable[] a, int low, int high) {
        System.out.println("insertionSort called");
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && less(a[j], a[j-1]); j--)
                exchange(a, j, j-1);
    }
   /**
    * exchanges or swaps two numbers
    *
    * @param      a     { comparable type }
    * @param      i     { index of first element }
    * @param      j     { index of second element }
    */
    public void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * checks if the number is less or not
     *
     * @param      a     { comparable type }
     * @param      b     { comparable type }
     *
     * @return     { returns boolean value }
     */

     public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

}

