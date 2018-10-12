import java.util.Scanner;
import java.util.Comparator;
// import java.util.Iterator;
/**
 * Class for cube sum.
 * Thsi calss has i and j values and sum.
 * All are int type.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * sum of the cubes.
     */
    private final int sum;
    /**
     * values of 1st number.
     */
    private final int i;
    /**
     * value of 2nd number.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      x    { int type }
     * @param      y     { int type }
     */

    CubeSum(final int x, final int y) {
        this.sum = x * x * x + y * y * y;
        this.i = x;
        this.j = y;
    }
    /**
     * gets the i.
     *
     * @return     { int type }
     */

    public int geti() {
        return this.i;
    }
    /**
     * gets j.
     *
     * @return     { int type }
     */

    public int getj() {
        return this.j;
    }
    /**
     * Gets the sum.
     *
     * @return     int type.
     */

    public int getSum() {
        return this.sum;
    }

    /**
     * compares two objects of CubeSum type
     * The time complexity is O(1).
     * .
     *
     * @param      that  The that
     *
     * @return     { int type }
     */

    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
}


/**
 * Class for minimum pq.
 * the heap of min type is created.
 *
 * @param      <Key>  The key
 */


class MinPQ<Key> {
    /**
     * key generic.
     */
    private Key[] pq;
    /**
     * size of the heap.
     */
    private int n;
    /**
     * comparator.
     */
    private Comparator<Key> comparator;  // optional comparator

    /**
     * Constructs the object.
     * overloaded constructor.
     *
     * @param      initCapacity  The initialize capacity.
     */
    MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Constructs the object.
     * overloaded constructor.
     * This constructor is called from main method.
     */
    MinPQ() {
        this(1);
    }
    /**
     * Constructs the object.
     * overloaded constructor.
     *
     * @param      initCapacity  The initialize capacity of int type
     * @param      comparat    The comparator
     */

    MinPQ(final int initCapacity, final Comparator<Key> comparat) {
        this.comparator = comparat;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Constructs the object.
     *
     *
     * @param      comparato  The comparator
     */


    MinPQ(final Comparator<Key> comparato) {
        this(1, comparato);
    }
    /**
     * Determines if empty.
     * The time complexity is O(1).
     *
     *
     * @return     True if empty, False otherwise.
     */


    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * size of the heap.
     * The time complexity is O(1).
     *
     *
     * @return     { returns int }
     */
    public int size() {
        return n;
    }

   /**
    * resizes the array.
    * insert method will call this method.
     * The time complexity is O(N).
    *
    *
    * @param      capacity  The capacity of int
    */

    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * inserts the object CubeSum.
     * The insertion method calls swim method.
     * The time complexity is O(1).
     *
     *
     * @param      x     { key of Cube Sum object }
     */

    public void insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }
    /**
     * deletes the root node.
     * The time complexity is O(1).
     *
     *
     * @return     { returns key of CubeSum object }
     */

    public Key delMin() {
        final int four = 4;
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        return min;
    }
    /**
     * swim operation is called in insert.
     * the node is inserted at end.
     * The element them swims.
     * The time complexity is O(logN).
     *
     *
     * @param      key     { parameter_description }
     */

    private void swim(final int key) {
        int k = key;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * sinks the value.
     * Sink operation is used to delete element.
     * The time complexity is O(logN).
     *
     *
     * @param      key     {index of int type }
     */

    private void sink(final int key) {
        int k = key;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * compares two objects.
     * The time complexity is O(1).
     *
     *
     * @param      i     { index of int type }
     * @param      j    { index of int type }
     *
     * @return     { returns boolean type }
     */


    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * exchanges two objects in heap.
     * The time complexity is O(1).
     *
     * @param      i     { index of int type }
     * @param      j     { index of int type }
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


}



/**
 * class Solution.
 * reads input.
 * creates object for minpq.
 * The generic is of class CubeSum.
 */

final class Solution {
    /**
     * Constructs the object.
     * The time complexity is O(Nb).
     *
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner input = new Scanner(System.in);
        final int six = 600;
        int count = 0;
        int n = six;
        String[] tokens = input.nextLine().split(" ");
        int number = Integer.parseInt(tokens[0]);
        int pair = Integer.parseInt(tokens[1]);
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int temp = -1;

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (temp == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == pair - 1) {
                number--;
                if (number == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            temp = s.getSum();
            // System.out.println(s);
            if (s.getj() < n) {
                pq.insert(new CubeSum(s.geti(), s.getj() + 1));
            }
        }
    }
}

