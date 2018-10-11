import java.util.Scanner;
/**
 * Class for book key.
 * class has three attributes.
 *
 */
class BookKey implements Comparable<BookKey> {
	private String name;
	private String author;
	private float price;

	/**
	 * Constructs the object.
	 *
	 * @param      n     { String n }
	 * @param      a     { String a }
	 * @param      p     { String p }
	 */

	BookKey(String n, String a, float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}

	/**
	 * gets the name
	 *
	 * @return     The name of string type.
	 */

	public String getName() {
		return this.name;
	}

	/**
	 * override method
	 *
	 * @param      that  The that
	 *
	 * @return     { returns int }
	 */

	public int compareTo(BookKey that){
		return -1;
	}
}

/**
 * Class for binary search tree.
 *
 * @param      <E>      { Generic type }
 * @param      <Value>  Integer type
 */
class BinarySearchTree<E extends Comparable<E>, Value> {
	/**
	 * size of the tree.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	BinarySearchTree() {

	}

	Node root;
    /**
     * Class for node.
     * Node class has a key, value.
     * left node address.
     * right node address.
     */
	class Node {
		BookKey key;
		Value value;
		Node left;
		Node right;
        /**
         * Constructs the object.
         *
         * @param      key    The key of Bookkey class.
         * @param      value  The value of int type.
         */
		Node(BookKey key, Value value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right =  null;
		}

	}
	/**
	 * puts the value in trees.
	 * The time complexity is O(logN).
	 *
	 * @param      key   The key of Bookkey class.
	 * @param      val   The value of int type.
	 */

	 public void put(BookKey key, Value val) {
        if (key == null) {
        	return;
        }
        root = put(root, key, val);
    }
    /**
     * puts the keys and values.
     * overloaded method.
	 * The time complexity is O(logN).
     * The binary search looks for half of the values.
     *
     * @param      x     { NODE TYPE }
     * @param      key   The key of bookkey.
     * @param      val   The value of int type.
     *
     * @return     { returns node type. That becomes root }
     */

    private Node put(Node x, BookKey key, Value val) {
    	size++;
        if (x == null) {
        	return new Node(key, val);
        }
        int cmp = key.getName().compareTo(x.key.getName());
        if (cmp < 0) {
        	x.left  = put(x.left,  key, val);
        }
        else if (cmp > 0) {
        	x.right = put(x.right, key, val);
        }
        else {
        	x.value = val;
        }
        return x;
    }

    /**
     *
     * get method for that particular key.
	 * The time complexity is O(logN).
     *
     * @param      key   The key if bookkey class.
     *
     * @return     { returns int }
     */

    public Value get(BookKey key) {
        return get(root, key);
    }

    /**
     * gets the key.
     * overloaded method.
	 * The time complexity is O(logN).
     * The traversal is only for logN times.
     *
     * @param      x     { Node x - root node }
     * @param      key   The key of bookkey class
     *
     * @return     { returns int }
     */

    private Value get(Node x, BookKey key) {
        if(x == null) {
        	return null;
        }
        int cmp = key.getName().compareTo(x.key.getName());
        if (cmp < 0) {
        	return get(x.left, key);
        }
        else if (cmp > 0) {
        	return get(x.right, key);
        }
        else {
        	 return x.value;
        }
    }
}

/**
 * Class for solution.
 * reads input.
 * time complexity is N.
 */

final class Solution {
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		BinarySearchTree<BookKey, Integer> binarySearch = new BinarySearchTree<BookKey, Integer>();
		while(input.hasNext()) {
			String[] tokens = input.nextLine().split(",");
            switch(tokens[0]) {
            	case "put":
            	BookKey key = new BookKey(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
            	Integer value = Integer.parseInt(tokens[4]);
            	binarySearch.put(key, value);
            	break;
            	case "get":
            	BookKey key1 = new BookKey(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
            	System.out.println(binarySearch.get(key1));
            	break;
            	default:
            	break;

            }

		}
	}
}