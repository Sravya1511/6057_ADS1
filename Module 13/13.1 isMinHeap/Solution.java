import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
class MinPQ<E extends Comparable<E>> {
	E[] pq;
	int n;
	Comparator<E> comparator;
	MinPQ(E[] array, int size) {
        pq = array;
        n = size;
	}

	private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<E>) pq[i]).compareTo( pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
     // @Override
    // public int compareTo(MinPQ) {
    //     this.pq
    // }

    private void exch(int i, int j) {
        E swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a min heap?
    public boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
    	// System.out.println(k);+
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String type = input.nextLine();
		int n = Integer.parseInt(input.nextLine());
		switch(type) {
			case "String":
			for(int i = 0; i<n; i++) {

				String[] tokens = input.nextLine().split(",");
				// System.out.println(Arrays.toString(tokens));
				// System.out.println(tokens.length);

				// String[] res = new String[tokens.length+1];
				// int m = 1;
				// for(int k = 0; k<tokens.length; k++) {
    //                   res[m] = tokens[k];
    //                   m++;
				// }
				// System.out.println(Arrays.toString(res));
				// System.out.println(res.length);
				MinPQ<String> stringArray = new MinPQ<String>(tokens, tokens.length);
				System.out.println(stringArray.isMinHeap());
			}
			break;
		}

	}
}