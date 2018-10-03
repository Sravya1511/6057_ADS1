import java.util.*;
class MergeSort {

    MergeSort() {

    }
    /**
     * Time complexity is O(N).
     */
    public void merge(Comparable[] array, Comparable[] auxilary, int low, int mid, int high) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid+1, high);

        int i = low;
        int j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i > mid)
                auxilary[k] = array[j++];
            else if (j > high)
                auxilary[k] = array[i++];
            else if (less(array[j], array[i]))
                auxilary[k] = array[j++];
            else
                auxilary[k] = array[i++];
        }
        assert isSorted(auxilary, low, high);
    }
    /**
     * Time complexity is O(1)
     */
    private void sort(Comparable[] array, Comparable[] auxilary, int low, int high) {
        if (high <= low + 7) {
            insertionSort(auxilary, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(auxilary, array, low, mid);
        sort(auxilary, array, mid+1, high);

        if (!less(array[mid+1], array[mid])) {
           for (int i = low; i <= high; i++) {
            auxilary[i] = array[i];
            }
            System.out.println("Array is already sorted. So, skipped the call to merge...");
           return;
        }
        merge(array, auxilary, low, mid, high);
    }
    /**
     * Time complexity is O(1)
     */
    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length-1);
        assert isSorted(a);
    }
    /**
     * Time complexity is O(N^2)
     */
    public void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
    /**
     * Time complexity is O(1)
     */
    public void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * Time complexity is O(1)
     */
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Time complexity is O(1).
     */
    public boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Time complexity is O(N)
     */
    public boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) {
                return false;
            }
        return true;
    }
    /**
     * Time complexity is O(N)
     */
    // public Object show(Object[] a) {
    //     String s = "[";
    //     int i;
    //     for (i = 0; i < a.length - 1; i++) {
    //         s += a[i] + ", ";
    //     }
    //     s = s + a[a.length - 1] + "]";
    //     return s;
    // }
}

class Solution {
    public static void main(String[] args) {
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
