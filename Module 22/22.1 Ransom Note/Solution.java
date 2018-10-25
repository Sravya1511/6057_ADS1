import java.util.Scanner;
/**
 * Class for solution.
 *
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 *
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
	    Scanner input = new Scanner(System.in);
        String[] tokens = input.nextLine().split(" ");
        int m = Integer.parseInt(tokens[0]);
        int n = Integer.parseInt(tokens[1]);
        String[] magazine = input.nextLine().split(" ");
        String[] note = input.nextLine().split(" ");
        SeparateChainingHashST<String, Integer> mag = new SeparateChainingHashST<String, Integer>();
        SeparateChainingHashST<String, Integer> notes = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; i < m; i++) {
            mag.put(magazine[i], 0);
        }
        for (int j = 0; j < n; j++) {
            notes.put(note[j], 0);
        }
        for (int i = 0; i < m; i++) {
            int count = mag.get(magazine[i]);
            if (mag.contains(magazine[i])) {
                mag.put(magazine[i], count + 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!mag.contains(note[j])) {
                System.out.println("No");
                return;
            } else if (mag.contains(note[j])) {
                int num = notes.get(note[j]);
                if (notes.contains(note[j])) {
                    notes.put(note[j], num + 1);
                } else {
                    notes.put(note[j], 1);
                }
                if (notes.get(note[j]) > mag.get(note[j])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
	}
}

/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */


class SeparateChainingHashST<Key, Value> {
	/**
	 * capacity of hash table array
	 */

    private static final int INIT_CAPACITY = 4;
    /**
     * size of the chain
     */

    private int n;
    /**
     * size of array.
     */

    private int m;
    /**
     * sequential array with key and value.
     */

    private SequentialSearchST<Key, Value>[] st;
    /**
     * overloaded construstor.
     */

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * overloaded constructor.
     *
     * @param      m     { size of the array }
     */

    public SeparateChainingHashST(final int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }

    /**
     * generates hash code.
     *
     * @param      key   The key
     *
     * @return     { returns hash code }
     */

    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * size of the hashtable.
     *
     * @return     { returns size }
     */

    public int size() {
        return n;
    }
    /**
     * determines if the key is present or not.
     *
     * @param      key   The key
     *
     * @return     { returns boolean }
     */

    public boolean contains(final Key key) {
        return get(key) != null;
    }

    /**
     * the value of that key
     *
     * @param      key   The key
     *
     * @return     { returns value }
     */

    public Value get(final Key key) {
        int i = hash(key);
        return st[i].get(key);
    }
    /**
     * Inserts the key value pair into the hash table.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }
}

/**
 * Class for sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */

class SequentialSearchST<Key, Value> {
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
       for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }


    public void put(Key key, Value val) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
}




