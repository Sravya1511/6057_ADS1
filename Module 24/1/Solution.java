import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int lines = Integer.parseInt(input.nextLine());
		LinearProbingHashing lpt = new LinearProbingHashing();
		for(int i = 0; i<lines; i++) {
            String[] tokens = input.nextLine().split(",");
            lpt.put(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
		}
		int output = Integer.parseInt(input.nextLine());
		for(int i = 0; i<output; i++) {
			String[] tokens = input.nextLine().split(" ");
			switch(tokens[2]) {
				case "1":
				if(lpt.getName(tokens[1]) != null) {
					System.out.println(lpt.getName(tokens[1]));
				}
				else {
					System.out.println("Student doesn't exists...");
				}
				break;
				case "2":
				if(lpt.getMarks(tokens[1]) != null) {
					System.out.println((lpt.getMarks(tokens[1])));
				}
				else {
					System.out.println("Student doesn't exists...");
				}
				break;

			}
		}
	}
}

/**
 * Class for linear probing hashing.
 *
 * @param      <Key>    The key
 * @param      <ValueName>  The value
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
     * array of values - value type.
     */
    private ValueName[] values;
    private Double[] values1;

    /**
     * overloaded constructor.
     */

    LinearProbingHashing() {
        this(CAPACITY);
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
        values = (ValueName[]) new Object[m];
        values1 =  new Double[m];
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
     * The time complexity O(N).
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
     * The time complexity O(N).
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
     * The time complexity O(N).
     *
     *
     * @param      c  The capacity
     */

    private void resize(final int c) {
        LinearProbingHashing<Key, ValueName, Double> temp = new
        LinearProbingHashing<Key, ValueName, Double>(c);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i], values1[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        values1 = temp.values1;
        m    = temp.m;
    }

    /**
     * inserts value in array.
     * The time complexity O(N).
     *
     *
     * @param      key   The key
     * @param      val   The value
     */

    public void put(final Key key, final ValueName val, final Double val1) {
        // if (val == null) {
        //     delete(key);
        //     return;
        // }
        if (n >= m / 2) {
             resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = val;
                values1[i] = val1;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        values1[i] = val1;
        n++;
    }
    /**
     * gets the value of the key.
     * The time complexity O(N).
     *
     *
     * @param      key   The key
     *
     * @return     { returns value }
     */

    public ValueName getName(final Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }

        return null;
    }

    public Double getMarks(final Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return values1[i];
            }
        }

        return null;
    }
}