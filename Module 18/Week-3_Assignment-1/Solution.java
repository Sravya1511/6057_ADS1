import java.util.Scanner;
import java.util.Comparator;
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

class Set {

	int size;
	String[] list;

	Set() {
       list = new String[20];
       size = 0;
	}

	public boolean contains(final String item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
            return true;
            }
        }
        return false;
    }

    public void add(String item) {
    	if (size == 0) {
    		list[size++] = item;
    	}
    	else if(!contains(item)) {
    		list[size++] = item;
    	}
    }

    public void print() {
    	for(int i = 0; i<size; i++) {
    		System.out.println(list[i]);
    	}
    }

}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		SymbolTable<String, Integer> symbolMax = new SymbolTable<String, Integer>(30);
		SymbolTable<String, Integer> symbolMin = new SymbolTable<String, Integer>(30);
		Set set = new Set();

		for(int i = 0; i<6; i++) {
			MinPQ<Stock> stMinPQ = new MinPQ<Stock>();
			MaxPQ<Stock> stMaxPQ = new MaxPQ<Stock>();
			for(int j = 0; j<n; j++) {
				String[] tokens = input.nextLine().split(",");
				stMinPQ.insert(new Stock(tokens[0], Float.parseFloat(tokens[1])));
				set.add(tokens[0]);
				stMaxPQ.insert(new Stock(tokens[0], Float.parseFloat(tokens[1])));
				set.add(tokens[0]);
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
                case "intersection":
                set.print();

			}
		}
	}
}


class SymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * key array of type key.
     */
    private Key[] keys;
    /**
     * value array of value Type.
     */
    private int[] values;
    /**
     * size of the table.
     */
    private int n = 0;
    /**
     * Constructs the object.
     * The keys array of type Key.
     * The values array of type value.
     *
     * @param      size  The size of int type.
     */

    SymbolTable(final int size) {
        keys = (Key[]) new Comparable[size];
        values =  new int[size];
    }

    public int size() {
    	return n;
    }

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

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        }
        return false;
    }
}

class MinPQ<Key> {

	Key[] pq;
	int n;
    Comparator<Key> comparator;


	MinPQ() {
    this(1);
    }

	MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    MinPQ(final int initCapacity, final Comparator<Key> comparat) {
        this.comparator = comparat;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    MinPQ(final Comparator<Key> comparato) {
        this(1, comparato);
    }

    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }

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

    private void swim(final int key) {
        int k = key;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

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

    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

     private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}

class MaxPQ<Key> {

	Key[] pq;
	int n;
    Comparator<Key> comparator;


	MaxPQ() {
    this(1);
    }

	MaxPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    MaxPQ(final int initCapacity, final Comparator<Key> comparat) {
        this.comparator = comparat;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    MaxPQ(final Comparator<Key> comparato) {
        this(1, comparato);
    }

    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }

    public Key delMax() {
        final int four = 4;
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        return max;
    }

    private void swim(final int key) {
        int k = key;
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

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

    private boolean less(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

     private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}

