import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
/**
 * Class for cube sum.
 * Thsi calss has i and j values and sum.
 * All are int type.
 */
class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      i     { int type }
     * @param      j     { int type }
     */

    public CubeSum(final int i, final int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
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
     * compares two objects of CubeSum type.
     *
     * @param      that  The that
     *
     * @return     { int type }
     */

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
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
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    /**
     * Constructs the object.
     * overloaded constructor.
     *
     * @param      initCapacity  The initialize capacity.
     */
    public MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Constructs the object.
     * overloaded constructor.
     * This constructor is called from main method.
     */
    public MinPQ() {
        this(1);
    }
    /**
     * Constructs the object.
     * overloaded constructor.
     *
     * @param      initCapacity  The initialize capacity of int type
     * @param      comparator    The comparator
     */

    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      comparator  The comparator
     */


    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }


    public boolean isEmpty() {
        return n == 0;
    }


    public int size() {
        return n;
    }


    public Key min() {
        return pq[1];
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }


    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
    }

    public Key delMin() {
        // if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        // assert isMinHeap();
        return min;
    }




    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


}





class Solution {
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int count = 0;
        int n = 600;
        String[] tokens = input.nextLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);


        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int temp = -1;

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if(temp == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if(count == M-1) {
                N--;
                if(N == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            temp = s.getSum();
            // System.out.println(s);
            if (s.getj() < n)
                pq.insert(new CubeSum(s.geti(), s.getj() + 1));
        }
    }
}

