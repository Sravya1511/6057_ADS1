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

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		for(int i = 0; i<6; i++) {
			MinPQ<Stock> st = new MinPQ<Stock>();
			MaxPQ<Stock> stm = new MaxPQ<Stock>();
			for(int j = 0; j<n; j++) {
				String[] tokens = input.nextLine().split(",");
				st.insert(new Stock(tokens[0], Float.parseFloat(tokens[1])));
				stm.insert(new Stock(tokens[0], Float.parseFloat(tokens[1])));
			}
			for(int k = 0; k<5; k++) {
				System.out.println(stm.delMax());
			}
			System.out.println();
			for(int k = 0; k<5; k++) {
				System.out.println(st.delMin());
			}
			System.out.println();
		}
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

