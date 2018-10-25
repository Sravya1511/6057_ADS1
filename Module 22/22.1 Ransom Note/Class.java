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
     * The time complexity is O(N).
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
     * The time complexity is O(1).
     *
     *
     * @return     { returns size }
     */

    public int size() {
        return n;
    }
    /**
     * determines if the key is present or not.
     * The time complexity is O(N).
     *
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
     * The time complexity is O(N).
     *
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
     * The time complexity is O(N).
     *
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
     *
     * Returns the number of key-value pairs in this symbol table.
     * The time complexity is 1.
     *
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     * The time complexity is 1.
     *
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
     * The time complexity is O(N).
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
     * The time complexity is O(N).
     *
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

    /**
     * inserts element at begining.
     * The time complexity is O(1).
     *
     *
     * @param      key   The key
     * @param      val   The value
     */


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




