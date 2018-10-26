import java.util.Scanner;
/**
 * Class for linear probing hashing.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashing<Key, Value> {
	/**
	 * capacity of the linear array.
	 */
	static final int capacity = 4;
	/**
	 * number of key value pairs.
	 */
	private int n;
	/**
	 * size of linear probing array.
	 */
	private int m;
	/**
	 * array of keys - key type.
	 */
	private Key[] keys;
	/**
	 * array of values - value type.
	 */
	private Value[] values;

	/**
	 * overloaded constructor.
	 */

	LinearProbingHashing() {
        this(capacity);
    }

    /**
     * constructor.
     *
     * @param      capa  The capacity
     */

    LinearProbingHashing(final int capa) {
        m = capa;
        n = 0;
        keys = (Key[])   new Object[m];
        values = (Value[]) new Object[m];
    }
    /**
     * size of the array.
     *
     * @return     { returns size }
     */

    public int size() {
        return n;
    }
    /**
     * checks if empty or not.
     *
     * @return     True if empty, False otherwise.
     */

    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * checks if there is key in array or not.
     *
     * @param      key   The key
     *
     * @return     { returns true or false }
     */

    public boolean contains(final Key key) {
        return get(key) != null;
    }

    /**
     * finds hash code of the key
     *
     * @param      key   The key.
     *
     * @return     { returns hash code }
     */

    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * resizes the array.
     *
     * @param      capacity  The capacity
     */

    private void resize(final int capacity) {
        LinearProbingHashing<Key, Value> temp = new
        LinearProbingHashing<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        m    = temp.m;
    }

    /**
     * inserts value in array.
     *
     * @param      key   The key
     * @param      val   The value
     */

    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m / 2) {
        	 resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        n++;
    }
    /**
     * gets the value of the key.
     *
     * @param      key   The key
     *
     * @return     { returns value }
     */

    public Value get(final Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
        	if (keys[i].equals(key)) {
                return values[i];
            }
        }

        return null;
    }
    /**
     * deletes the key value pair.
     *
     * @param      key   The key
     */

    public void delete(final Key key) {

        if (!contains(key)) {
        	return;
        }

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        values[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;
        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / 8) {
        	resize(m / 2);
        }
    }
    /**
     * displays the key value pair.
     */

    public void display() {
    	String str = "{";
    	for (int i = 0; i < m; i++) {
    		if (keys[i] != null) {
    			str += keys[i] + ":" + values[i] + ", ";
    		}
    	}
        String a = str.substring(0, str.length() - 2);
    	a = a + "}";
    	System.out.println(a);
    }
}
/**
 * class for solution.
 */

final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * reads input.
	 * Creates object for linearProbingHashing class.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		LinearProbingHashing lpt = new LinearProbingHashing();
		int lines = Integer.parseInt(input.nextLine());
		for (int i = 0; i < lines; i++) {
			String[] tokens = input.nextLine().split(" ");
			switch (tokens[0]) {
				case "put":
				lpt.put(tokens[1], Integer.parseInt(tokens[2]));
				break;
				case "display":
				lpt.display();
				break;
				case "delete":
				lpt.delete(tokens[1]);
				break;
				case "get":
				System.out.println(lpt.get(tokens[1]));
				break;
				default:
				break;

			}
		}
	}
}