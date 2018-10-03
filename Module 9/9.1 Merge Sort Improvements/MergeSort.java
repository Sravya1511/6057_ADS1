/**
 *
 * Class for merge sort.
 * This sort has sort method and merge method.
 * The sort method recursively calls itself.
 */
class MergeSort {
    /**
     * Constructs the object.
     */

    MergeSort() {

    }
    /**
     * The merge method merges the two arrays in sorted manner.
     * The time complexity is O(NLog(N)).
     *
     */
    /**
     * This function merges two arrays
     *
     * @param      array     The array of type comparable
     * @param      auxilary  The auxilary of type comparable
     * @param      low       The low of type int
     * @param      mid       The middle of type int
     * @param      high      The high of type int
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
     * Time complexity is O(1).
     * The sort method calls itself recursively.
     */
    /**
     * sort
     *
     * @param      array     The array of type comparable
     * @param      auxilary  The auxilary of type comparable
     * @param      low       The low of type int
     * @param      high      The high of type int
     */
    private void sort(Comparable[] array, Comparable[] auxilary, int low, int high) {
        if (high - low <=  7) {
            Insertion insertion = new Insertion();
            insertion.insertionSort(auxilary, low, high);
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
     * sort method is called in main
     * overload method
     * time complexity is O(1).
     *
     * @param      a     { array of comparable type }
     */
    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length-1);
        assert isSorted(a);
    }


    /**
     * checks if a number is less than other number.
     * Time complexity is O(1)
     *
     * @param      a     {comparable type} }
     * @param      b     { comparable type }
     *
     * @return     { returns true or false }
     */


    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Determines if sorted. or not.
     * Time complexity is O(1).
     *
     * @param      a     { comparable type }
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /**
     * Determines if sorted.
     * over loaded method
     * Time complexity is O(N)
     *
     * @param      a     {Comparable type }
     * @param      low    integer type
     * @param      high   integer type
     *
     * @return     True if sorted, False otherwise.
     */

    public boolean isSorted(Comparable[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++)
            if (less(a[i], a[i-1])) {
                return false;
            }
        return true;
    }

}

/**
 * Time complexity for insertion is O(N^2).
 * Class for insertion.
 */
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