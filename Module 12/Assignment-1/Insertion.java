import java.util.Comparator;
/**
 * Class for insertion.
 */
class Insertion {
    /**
     * Constructs the object.
     */

	public Insertion() {}
    /**
     * sorts the object array.
     *
     * @param      a           { object of student type}.
     * @param      comparator  The comparator.
     */

	public static void sort(final Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && great(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * compares two objects of student class
     *
     * @param      v           { student object }
     * @param      w           { student object}
     * @param      comparator  The comparator
     *
     * @return     { returns boolean }
     */
    private static  boolean great(final Object v, final Object w, Comparator comparator) {
        return comparator.compare(v, w) > 0;
    }

    /**
     * exchanges two objects
     *
     * @param      a     { student object }
     * @param      i     { index of int type}
     * @param      j     { index of int type }
     */

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}