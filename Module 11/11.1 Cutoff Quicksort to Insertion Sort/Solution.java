import java.util.Scanner;
import java.util.Arrays;
class QuickSort {

     QuickSort() { }


    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }


    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }
            // check if pointers cross
            if (i >= j) break;
            exch(a, i, j);
        }
        // put partitioning item v at a[j]
        exch(a, lo, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        System.out.println(Arrays.toString(a));
        return j;
    }


    // public static Comparable select(Comparable[] a, int k) {
    //     if (k < 0 || k >= a.length) {
    //         throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
    //     }
    //     StdRandom.shuffle(a);
    //     int lo = 0, hi = a.length - 1;
    //     while (hi > lo) {
    //         int i = partition(a, lo, hi);
    //         if      (i > k) hi = i - 1;
    //         else if (i < k) lo = i + 1;
    //         else return a[i];
    //     }
    //     return a[lo];
    // }




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
}

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for(int i = 0; i<n*2; i++) {
            QuickSort quick = new QuickSort();
            int cutOff = Integer.parseInt(input.nextLine());
            String[] array = input.nextLine().split(" ");
            quick.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }
}



