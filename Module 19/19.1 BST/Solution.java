import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book>{
	 /**
     * Name of book.
     */
    private String name;
    /**
     * author of book.
     */
    private String author;
    /**
     * price of book.
     */
    private float price;

    /**
     * Constructs the object.
     *
     * @param      n     { String n }
     * @param      a     { String a }
     * @param      p     { String p }
     */

    Book(final String n, final String a, final float p) {
        this.name = n;
        this.author = a;
        this.price = p;
    }
    /**
     * Gets the name.
     * The time complexity is O(1).
     *
     * @return     The name of string type.
     */

	public String getName() {
		return this.name;
	}

	/**
	 * Gets the author.
     * The time complexity is O(1).
	 *
	 *
	 * @return     The author of string type.
	 */

	public String getAuthor() {
		return this.author;
	}

	/**
	 * Gets the price.
     * The time complexity is O(1).
	 *
	 * @return     The price of int type.
	 */

	public float getPrice() {
		return this.price;
	}
	/**
	 * compares two names of the authors.
     * The time complexity is O(1).
	 *
	 * @param      that  The that of Book class
	 *
	 * @return     { int }
	 */

	public int compareTo(Book that) {
		return this.name.compareTo(that.name);
	}

}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * main method. reads input.
     * The time complexity is O().
	 *
	 * @param      args  The arguments
	 */
    public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        Scanner input = new Scanner(System.in);
        BinarySearchTree<Book, Integer>
        binarySearch = new
        BinarySearchTree<Book, Integer>();
        while (input.hasNext()) {
            String[] tokens = input.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                Book key = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                Integer value = Integer.parseInt(tokens[four]);
                binarySearch.put(key, value);
                break;
                case "get":
                Book key1 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                System.out.println(binarySearch.get(key1));
                break;
                case "max":
                Book key2 = binarySearch.max();
                binarySearch.toString(key2);
                break;
                case "min":
                Book key3 = binarySearch.min();
                binarySearch.toString(key3);
                break;
                case "floor":
                Book key4 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.toString(binarySearch.floor(key4));
                break;
                case "ceiling":
                Book key5 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.toString(binarySearch.ceiling(key5));
                break;
                case "select":
                binarySearch.toString(binarySearch.select(Integer.parseInt(tokens[1])));
                break;
                default:
                break;

            }
        }
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
    private int size;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {

    }

/**
 * root of node type.
 */
    private Node root;
    /**
     * Class for node.
     * Node class has a key, value.
     * left node address.
     * right node address.
     */
    class Node {
        /**
         * key of node.
         */
        private E key;
        /**
         * value of node.
         */
        private Value value;
        /**
         * left node address.
         */
        private Node left;
        /**
         * right node address.
         */
        private Node right;
        private int size;
        /**
         * Constructs the object.
         *
         * @param      k    The key of Bookkey class.
         * @param      v  The value of int type.
         */
        Node(final E k, final Value v, int size) {
            this.key = k;
            this.value = v;
            this.left = null;
            this.right =  null;
            this.size = size;
        }

    }
    /**
     * puts the value in trees.
     * The time complexity is O(logN).
     *
     * @param      key   The key of Bookkey class.
     * @param      val   The value of int type.
     */

     public void put(final E key, final Value val) {
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

    private Node put(final Node x, final E key, final Value val) {
        size++;
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.value = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
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

    public Value get(final E key) {
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

    private Value get(final Node x, final E key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
             return x.value;
        }
    }

    /**
     * method to find maximum element in binary tree.
     *
     * @return     { book object of book class }
     */
     public E max() {

        return max(root).key;
    }

    /**
     * The maximum node is found.
     *
     * @param      x     { Node type }
     *
     * @return     { returns maximum node}
     */

    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }
    /**
     * The minimum node is found.
     *
     * @return     {book class }
     */

    public E min() {

        return min(root).key;
    }
    /**
     * The minimum node is found.
     *
     * @param      x     { Node class }
     *
     * @return     { Node type }
     */

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }
    /**
     * Returns the largest key in the symbol table.
     * less than or equal to key.
     *
     * @param      key   The key of book class
     *
     * @return     { returns book type }
     */

    public E floor(E key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    /**
     * returns less or equal to key.
     *
     * @param      x     { Node type }
     * @param      key   The key
     *
     * @return     { returns node }
     */

    private Node floor(Node x, E key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    /**
     * returns greater than or equal to key.
     *
     * @param      key   The key of book class type.
     *
     * @return     { returns book type }
     */

    public E ceiling(E key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }
    /**
     * returns greater than or equal to value.
     *
     * @param      x     { Node type }
     * @param      key   The key of book type.
     *
     * @return     { returns node }
     */

    private Node ceiling(Node x, E key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }
    /**
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    public E select(int k) {

        Node x = select(root, k);
        return x.key;
    }
    /**
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,  k);
        else if (t < k) return select(x.right, k-t-1);
        else            return x;
    }
    /**
     * size of the binary tree.
     *
     * @return     { int type }
     */

    public int size() {
        return size(root);
    }

    /**
     * return number of key-value pairs in BST rooted at x.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    /**
     * prints the book class.
     *
     * @param      book  The book
     */

    public void toString(Book book) {
    	System.out.println(book.getName()+", "+
    		book.getAuthor()+", "+book.getPrice());
    }

}