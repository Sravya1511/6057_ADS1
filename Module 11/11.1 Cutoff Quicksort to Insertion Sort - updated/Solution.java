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
            System.out.println("insertionSort called");
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
        for(int i = 0; i<n; i++) {
            QuickSort quick = new QuickSort();
            int cutOff = Integer.parseInt(input.nextLine());
            String[] array = input.nextLine().split(" ");
            if (array[0].equals("")) {
                System.out.println("[]");
            }
            else {
            quick.sort(array, cutOff);
                     System.out.println(Arrays.toString(array));   }

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
        // System.out.println("insertionSort called");
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


// /**.
//  * { item_description }
//  */
// import java.util.Scanner;
// /**.
//  * { item_description }
//  */
// /**
//  * Class for sorting.
//  */
// class Sorting {

//     /**.
//      * Constructs the object.
//      */
//     Sorting() {
//         /**.
//          * { item_description }
//          */
//     }
// // time complexity for this method is O(N^2).
// // In first for loop and second loop it iterates through the size of array
// /**.
//      * { function_description }
//      *
//      * @param      arr  The arguments
//      * @param      low  The arguments
//      * @param      high  The arguments
//      */
//     public void insertion(final Comparable[] arr, final int low,
//      final int high) {
//         // int i = low;
//         // int j = high;
//         for (int i = low; i <= high; i++) {
//             for (int j = i; j > low && less(arr[j], arr[j - 1]); j--) {
//                 swap(arr, j, j - 1);
//             }
//         }
//     }
// // time complexity of this method is O(1). It swaps the elements only once.
// /**.
//      * { function_description }
//      *
//      * @param      arr  The arguments
//      * @param      j  The arguments
//      * @param      min  The arguments
//      */
//     public void swap(final Comparable[] arr, final int j, final int min) {
//         Comparable temp = arr[j];
//         arr[j] = arr[min];
//         arr[min] = temp;
//     }
// // time complexity of this method is O(N). It iterates through
// // the array to print all the objects in array.

//     /**.
//      * Returns a string representation of the object.
//      *
//      * @param      arr   The arr
//      *
//      * @return     String representation of the object.
//      */
//     public String toString(final Comparable[] arr) {
//         // System.out.println("in print");
//         String str = "[";
//         for (int i = 0; i < arr.length - 1; i++) {
//             str += arr[i] + ", ";
//         }
//         str += arr[arr.length - 1] + "]";
//         return str;
//     }
// // time complexity is O(log N)
// /**.
//      * { function_description }
//      *
//      * @param      arr  The arguments
//      * @param      low  The arguments
//      * @param      high  The arguments
//      * @param      cutOff  The arguments
//      */
//     public void sort(final Comparable[] arr, final int low,
//      final int high, final int cutOff) {
//         if (high <= low + cutOff - 1) {
//             insertion(arr, low, high);
//             System.out.println("insertionSort called");
//             return;
//         }
//         int k = partition(arr, low, high);
//         System.out.println(toString(arr));
//         sort(arr, low, k - 1, cutOff);
//         sort(arr, k + 1, high, cutOff);
//     }
// //time complexity is O(1)

//     /**.
//      * { function_description }
//      *
//      * @param      array   The array
//      * @param      cutOff  The cut off
//      */
//     public void sort(final Comparable[] array, final int cutOff) {
//         sort(array, 0, array.length - 1, cutOff);
//     }
// // time complexity is O(N)

//     /**.
//      * { function_description }
//      *
//      * @param      arr   The arr
//      * @param      low   The low
//      * @param      high  The high
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public int partition(final Comparable[] arr,
//      final int low, final int high) {
//         int i = low;
//         int j = high + 1;
//         while (true) {
//             while (less(arr[++i], arr[low])) {
//                 if (i == high) {
//                     break;
//                 }
//             }
//             while (less(arr[low], arr[--j])) {
//                 if (j == low) {
//                     break;
//                 }
//             }
//             if (i >= j) {
//                 break;
//             }
//             swap(arr, i, j);
//         }
//         swap(arr, low, j);
//         // System.out.println(toString(arr));
//         return j;
//     }
// // time complexity is O(1)

//     /**.
//      * { function_description }
//      *
//      * @param      a     { parameter_description }
//      * @param      b     { parameter_description }
//      *
//      * @return     { description_of_the_return_value }
//      */
//     public boolean less(final Comparable a, final Comparable b) {
//         return a.compareTo(b) < 0;
//     }
// }

// final class Solution {
//     /**.
//      * Constructs the object.
//      */
//     private Solution() {
//         /**.
//          * { item_description }
//          */
//     }
//     /**.
//      * { function_description }
//      *
//      * @param      args  The arguments
//      */
//     // time complexity for the main method is N
//     // Because there is one while loop.
//     // while loop iterates until it has next line i.e N times.
//     public static void main(final String[] args) {
//         Scanner sc = new Scanner(System.in);
//         Sorting sort = new Sorting();
//         int testcases = Integer.parseInt(sc.nextLine());
//         for (int i = 0; i < testcases; i++) {
//             int j = Integer.parseInt(sc.nextLine());
//             // sc.nextLine();
//             String line = sc.nextLine();
//             String[] tokens = line.split(" ");
//             if (tokens[0].equals("")) {
//                 System.out.println("[]");
//             } else {
//                 sort.sort(tokens, j);
//                 System.out.println(sort.toString(tokens));
//             }
//         }
//     }
// }



