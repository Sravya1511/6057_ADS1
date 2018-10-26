import java.util.Scanner;
class LinearProbingHashing<Key, Value> {
	static final int capacity = 4;
	private int n;
	private int m;
	private Key[] keys;
	private Value[] values;

	public LinearProbingHashing() {
        this(capacity);
    }

    public LinearProbingHashing(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        values = (Value[]) new Object[m];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
        LinearProbingHashing<Key, Value> temp = new LinearProbingHashing<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        m    = temp.m;
    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m/2) resize(2*m);

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

    public Value get(Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    public void delete(Key key) {

        if (!contains(key)) return;

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
        if (n > 0 && n <= m/8) resize(m/2);
    }

    public void display() {
    	System.out.print("{");
    	for(int i = 0; i<m-1; i++) {
    		if(keys[i]!=null) {
    			System.out.print(keys[i]+":"+values[i]+", ");
    		}
    	}
    	if(keys[m-1]!=null) {
    		System.out.print(keys[m-1]+":"+values[m-1]);
    	}
    	System.out.println("}");
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinearProbingHashing lpt = new LinearProbingHashing();
		int lines = Integer.parseInt(input.nextLine());
		for(int i = 0; i<lines; i++) {
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