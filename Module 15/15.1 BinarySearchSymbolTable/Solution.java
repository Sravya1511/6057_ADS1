import java.util.Scanner;
/**
 * Class for symbol table.
 * The Symbol table is used for inserting keys and corresponding
 * values.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SymbolTable<Key extends Comparable<Key>, Value> {
	Key[] keys;
	Value[] values;
	int n = 0;
	/**
	 * Constructs the object.
	 * The keys array of type Key.
	 * The values array of type value.
	 *
	 * @param      size  The size of int type.
	 */

	SymbolTable(int size) {
		keys = (Key[]) new Comparable[size];
		values = (Value[]) new Object[size];
	}
	/**
	 * The method inserts key and values.
	 * If the key is new, it is inserted.
	 * If the key already exists, the value is overrided.
	 * It calls rank method to know the index of the key to be placed.
	 * The time complexity is O(N).
	 *
	 * @param      key    The key of key type.
	 * @param      value  The value of value type.
	 */

	public void put(final Key key, final Value value) {
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
		for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
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
	 * @return     { description_of_the_return_value }
	 */

	public int rank(final Key key) {
        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    /**
     * checks if the table is empty or not.
     * The time complexity is O(1).
     *
     * @return     True if empty, False otherwise.
     */

    public boolean isEmpty() {
    	if (n == 0)
    		return true;
        return false;
    }
    /**
     * deletes the minimum element.
     * Calls min method and delete method.
     * The time complexity is O(1).
     *
     */

    public void deleteMin() {
        if (isEmpty()) return;
        delete(min());
    }
    /**
     * finds min value.
     * The min value is always present in 0th index.
     * The time complexity is O(1).
     *
     *
     * @return     { returns key }
     */

    public Key min() {
        if (isEmpty())
        	return null;
        return keys[0];
    }

    /**
     * deletes the particular elements.
     * The time complexity is O(N).
     *
     * @param      key   The key
     */

    public void delete(final Key key) {
        if (key == null) return;
        if (isEmpty()) return;

        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }

        n--;
        keys[n] = null;
        values[n] = null;
    }
    /**
     * checks if the symbol table contains the element or not.
     * The time complexity is O(1).
     * calls get method.
     *
     *
     * @param      key   The key
     *
     * @return     { returns true or false }
     */

    public boolean contains(final Key key) {
        if (key == null) {
        	return false;
        }
        return get(key) != null;
    }
    /**
     * max value is always the last element.
     * The time complexity is O(1)
     *
     *
     * @return     { returns key }
     */

    public Key max() {
        if (isEmpty()) {
        	return null;
        }
        return keys[n-1];
    }
    /**
     * floor method returns the value .
     * equal to or greater than the key value.
     * The time complexity is O(1).
     *
     *
     * @param      key   The key
     *
     * @return     { returns key }
     */

    public Key floor(final Key key) {
        if (key == null) {
        	return null;
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }
    /**
     * gets the value of that key.
     * The time complexity is O(1)
     * calls the rank method.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */

    public Value get(final Key key) {
        if (key == null) {
        	System.out.println("No key");
        	return null;
        }
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }
    /**
     * prints the keys and values.
     * The time complexity is O(N).
     *
     */

    public void print() {
    	for(int i = 0; i<keys.length; i++) {
    		if(keys[i]!=null)
    		System.out.println(keys[i]+" "+values[i]);
    	}
    }
}
/**
 * Class for solution.
 * reads input.
 */

final class Solution {
	/**
	 * Constructs the object.
	 */

	private Solution() {

	}
	/**
	 * creates object for symbolTable class.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] tokens = input.nextLine().split(" ");
		SymbolTable<String, Integer> st = new SymbolTable<String, Integer>(tokens.length);
		for (int i = 0; i < tokens.length; i++) {
			st.put(tokens[i], i);
		}
        // st.print();
        while(input.hasNext()) {
        	String[] m = input.nextLine().split(" ");
        	switch(m[0]) {
        		case "get":
        		System.out.println(st.get(m[1]));
                break;
                case"contains":
                System.out.println(st.contains(m[1]));
                break;
                case "max":
                System.out.println(st.max());
                break;
                case "rank":
                System.out.println(st.rank(m[1]));
                break;
                case "floor":
                System.out.println(st.floor(m[1]));
                break;
                case "deleteMin":
                st.deleteMin();
                break;
                case "keys":
                st.print();
                break;
                default:
                break;
        	}
        }
	}
}