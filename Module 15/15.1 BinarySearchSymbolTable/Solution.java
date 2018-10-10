import java.util.Scanner;
class SymbolTable<Key extends Comparable<Key>, Value> {
	Key[] keys;
	Value[] values;
	int n = 0;

	SymbolTable(int size) {
		keys = (Key[]) new Comparable[size];
		values = (Value[]) new Object[size];
	}

	public void put(Key key, Value value) {
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

	public int rank(Key key) {

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

    public boolean isEmpty() {
    	if (n == 0)
    		return true;
        return false;
    }

    public void deleteMin() {
        if (isEmpty()) return;
        delete(min());
    }

    public Key min() {
        if (isEmpty())
        	return null;
        return keys[0];
    }

    public void delete(Key key) {
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
        keys[n] = null;  // to avoid loitering
        values[n] = null;

        // // resize if 1/4 full
        // if (n > 0 && n == keys.length/4) resize(keys.length/2);

        // assert check();
    }



    public boolean contains(Key key) {
        if (key == null) {
        	return false;
        }
        return get(key) != null;
    }

    public Key max() {
        if (isEmpty()) {
        	return null;
        }
        return keys[n-1];
    }

    public Key floor(Key key) {
        if (key == null) {
        	// System.out.println("MOO");
        	return null;
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }



    public Value get(Key key) {
        if (key == null) {
        	System.out.println("No key");
        	return null;
        }
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    public void print() {
    	for(int i = 0; i<keys.length; i++) {
    		if(keys[i]!=null)
    		System.out.println(keys[i]+"  "+values[i]);
    	}
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] tokens = input.nextLine().split(" ");
		SymbolTable<String, Integer> st = new SymbolTable<String, Integer>(tokens.length);
		for(int i = 0; i<tokens.length; i++) {
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


        	}
        }
	}
}