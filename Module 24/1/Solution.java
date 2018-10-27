import java.util.Scanner;
/**
 * Class for solution.
 * reads input.
 * Creates object for linear probing hashing class.
 *
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * The student data has student name and marks with roll number.
	 * The search opeartion should be performed when student roll number is given.
	 * The search should be with an average constant time.
	 * The hash table can search a data within constant time.
	 * The time complexity is O(NlogN) -- worst case.
	 * The time complexity is O(N) -- best case.
	 *
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int lines = Integer.parseInt(input.nextLine());
		LinearProbingHashing lpt = new LinearProbingHashing();
		for (int i = 0; i < lines; i++) {
            String[] tokens = input.nextLine().split(",");
            lpt.put(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
		}
		int output = Integer.parseInt(input.nextLine());
		for (int i = 0; i < output; i++) {
			String[] tokens = input.nextLine().split(" ");
			switch (tokens[2]) {
				case "1":
				if(lpt.getName(tokens[1]) != null) {
					System.out.println(lpt.getName(tokens[1]));
				} else {
					System.out.println("Student doesn't exists...");
				}
				break;
				case "2":
				if(lpt.getMarks(tokens[1]) != null) {
					System.out.println((lpt.getMarks(tokens[1])));
				} else {
					System.out.println("Student doesn't exists...");
				}
				break;
				default:
				break;
			}
		}
	}
}

/**
 * Class for linear probing hashing.
 * This method for searching is preferred.
 *  because the serarch is performed in conatant time.
 *
 * @param      <Key>    The key of generic type
 * @param      <ValueName>  The value of generic type
 * @param      <ValueMarks>  The valueMarks of generic type
 *
 */
class LinearProbingHashing<Key, ValueName, ValueMarks> {
    /**
     * capacity of the linear array.
     */
    static final int CAPACITY = 4;
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
     * array of valueNames - value type.
     */
    private ValueName[] valueNames;
    /**
     * array of valueMarks - Double type.
     */
    private Double[] valueMarks;

    /**
     * overloaded constructor.
     */

    LinearProbingHashing() {
        this(CAPACITY);
    }

    /**
     * constructor.
     *
     * @param      capa  The capacity of int type.
     */

    LinearProbingHashing(final int capa) {
        m = capa;
        n = 0;
        keys = (Key[])   new Object[m];
        valueNames = (ValueName[]) new Object[m];
        valueMarks =  new Double[m];
    }
    /**
     * size of the array.
     * The time complexity O(1).
     *
     * @return     { returns size }
     */

    public int size() {
        return n;
    }
    /**
     * checks if empty or not.
     * The time complexity O(1).
     *
     *
     * @return     True if empty, False otherwise.
     */

    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * checks if there is key in array or not.
     * The time complexity O(logN*) -- worst case.
     * The time complexity O(3.5*) -- worst case.
     *
     *
     *
     * @param      key   The key
     *
     * @return     { returns true or false }
     */

    public boolean contains(final Key key) {
        return getName(key) != null;
    }

    /**
     * finds hash code of the key.
     * The time complexity O(1).
     *
     *
     * @param      key   The key.
     *
     * @return     { returns hash code }
     */

    private int hash(final Key key) {
        // final int ele = 11;
        final int x = 0x7fffffff;
        return (key.hashCode()) % m;
    }

    /**
     * resizes the array.
     * resize calls put method.
     * The time complexity O(logN*) -- worst case.
     * The time complexity O(3.5*) -- worst case.
     *
     *
     * @param      c  The capacity
     */

    private void resize(final int c) {
        LinearProbingHashing<Key, ValueName, Double> temp = new
        LinearProbingHashing<Key, ValueName, Double>(c);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], valueNames[i], valueMarks[i]);
            }
        }
        keys = temp.keys;
        valueNames = temp.valueNames;
        valueMarks = temp.valueMarks;
        m    = temp.m;
    }

    /**
     * inserts value in array.
     * The time complexity O(logN*) -- worst case.
     * The time complexity O(3.5*) -- worst case.
     *
     *
     * @param      key   The key
     * @param      val   The value
     */

    public void put(final Key key, final ValueName val, final Double val1) {
        if (n >= m / 2) {
             resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                valueNames[i] = val;
                valueMarks[i] = val1;
                return;
            }
        }
        keys[i] = key;
        valueNames[i] = val;
        valueMarks[i] = val1;
        n++;
    }
    /**
     * gets the valueName of the key.
     * The time complexity O(logN*) -- worst case.
     * The time complexity O(3.5*) -- worst case.
     *
     *
     * @param      key   The key of key type.
     *
     * @return     { returns value 0f ValueName type}
     */

    public ValueName getName(final Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return valueNames[i];
            }
        }

        return null;
    }
     /**
     * gets the valueMarks of the key.
     * The time complexity O(logN*) -- worst case.
     * The time complexity O(3.5*) -- worst case.
     *
     *
     * @param      key   The key of key type.
     *
     * @return     { returns value 0f Double type}
     */

    public Double getMarks(final Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return valueMarks[i];
            }
        }

        return null;
    }
}