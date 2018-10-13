import java.util.Scanner;
import java.util.Comparator;
/**
 * Class for stock.
 * stock has two parameters.
 *
 */
class Stock implements Comparable<Stock>{
	String name;
	float data;

	Stock(String n, float d) {
		this.name = n;
		this.data = d;
	}

	public String toString() {
		return this.name+" "+this.data;
	}

	public int compareTo(Stock that) {
		if (this.data < that.data) {
            return -1;
        }
        if (this.data > that.data) {
            return +1;
        }
        return this.name.compareTo(that.name);
    }
}


class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		SymbolTable<String, Integer> symbolMax = new SymbolTable<String, Integer>(30);
		SymbolTable<String, Integer> symbolMin = new SymbolTable<String, Integer>(30);

		for(int i = 0; i<6; i++) {
			MinPQ<Stock> stMinPQ = new MinPQ<Stock>();
			MaxPQ<Stock> stMaxPQ = new MaxPQ<Stock>();
			for(int j = 0; j<n; j++) {
				String[] tokens = input.nextLine().split(",");
				stMinPQ.insert(new Stock(tokens[0], Float.parseFloat(tokens[1])));
				// set.add(tokens[0]);
				stMaxPQ.insert(new Stock(tokens[0], Float.parseFloat(tokens[1])));
				// set.add(tokens[0]);
			}
			for(int k = 0; k<5; k++) {
				Stock a = stMaxPQ.delMax();
				System.out.println(a);
				symbolMax.put(a.name, 1);
			}
			System.out.println();
			for(int k = 0; k<5; k++) {
				Stock b = stMinPQ.delMin();
				System.out.println(b);
				symbolMin.put(b.name, 1);
			}
			System.out.println();
		}
        // System.out.println("Max SymbolTable");
		// symbolMax.print();
		// System.out.println("Min SymbolTable");
		// symbolMin.print();
		//
		int k = Integer.parseInt(input.nextLine());
		for(int i = 0; i<k; i++) {
			String[] tokens = input.nextLine().split(",");
			switch(tokens[0]) {
				case "get":
				if(tokens[1].equals("maxST")) {
					System.out.println(symbolMax.get(tokens[2]));
				}
				if(tokens[1].equals("minST")) {
					System.out.println(symbolMin.get(tokens[2]));
				}
				break;
                case "intersection":
                symbolMax.intersection(symbolMin.getKeys(), symbolMax.getKeys());
                break;

			}
		}
	}
}

/**
 * Class for symbol table.
 * The Symbol table is used for inserting keys and corresponding
 * values.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * key array of type key.
     */
    private Key[] keys;
    /**
     * value array of int Type.
     */
    private int[] values;
    /**
     * size of the table.
     */
    private int n = 0;
    /**
     * Constructs the object.
     * The keys array of type Key.
     * The values array of type int.
     *
     * @param      size  The size of int type.
     */

    SymbolTable(final int size) {
        keys = (Key[]) new Comparable[size];
        values =  new int[size];
    }
    /**
     * size of the symbol table
     *
     * @return     { returns int }
     */

    public int size() {
    	return n;
    }

    /**
     * The method inserts key and values.
     * If the key is new, it is inserted.
     * If the key already exists, the value is overrided.
     * It calls rank method to know the index of the key to be placed.
     * The time complexity is O(N). - worst case.
     *
     * @param      key    The key of key type.
     * @param      value  The value of int type.
     */

    public void put(final Key key, final int value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = values[i]+1;
            return;
        }
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }
    /**
     * The key is compared with all the keys and finds its position.
     * Rank is found using binary search algorithm.
     * The time complexity is O(logN).
     *
     * @param      key   The key
     *
     * @return     { returns int }
     */

    public int rank(final Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if     (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

     /**
     * gets the value of that key.
     * The time complexity is O(1)
     * calls the rank method.
     *
     * @param      key   The key
     *
     * @return     { returns key }
     */

    public int get(final Key key) {
        if (key == null) {
            System.out.println("No key");
            return 0;
        }
        if (isEmpty()) {
            return 0;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return 0;
    }
    /**
     * class intersection.
     *
     * @param      temp1  key type
     * @param      temp2  key type.
     */

    public void intersection(Key[] temp1, Key[] temp2) {
    	 for (int m = 0; m < temp1.length; m++) {
            for (int j = 0; j < temp2.length; j++) {
                    if (temp1[m].equals(temp2[j])) {
                          System.out.println(temp1[m]);
                        }
                    }
                }
    }

    /**
     * checks if the table is empty or not.
     * The time complexity is O(1).
     *
     * @return     True if empty, False otherwise.
     */

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        }
        return false;
    }
    /**
     * Gets the keys.
     *
     * @return     The keys.
     */

    public Key[] getKeys() {
    	return keys;
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
 * Class for maximum pq.
 * the heap of max type is created.
 *
 * @param      <Key>  The key
 */

class MaxPQ<Key> {
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
    MaxPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Constructs the object.
     * overloaded constructor.
     * This constructor is called from main method.
     */
    MaxPQ() {
        this(1);
    }
    /**
     * Constructs the object.
     * overloaded constructor.
     *
     * @param      initCapacity  The initialize capacity of int type
     * @param      comparat    The comparator
     */

    MaxPQ(final int initCapacity, final Comparator<Key> comparat) {
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


    MaxPQ(final Comparator<Key> comparato) {
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

    public Key delMax() {
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
        while (k > 1 && less(k / 2, k)) {
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
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
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


    private boolean less(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
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
