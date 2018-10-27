
import java.util.Scanner;
class BinarySearchTree<RollNum, Name, Marks> {
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
     * Node class has a roll, name.
     * left node address.
     * right node address.
     */
    class Node {

        private Integer roll;

        private Name name;

        private Double marks;
        private Node left;

        private Node right;

        private int size;

        Node(final Integer k, final Name v, final Double m, final int s) {
            this.roll = k;
            this.name = v;
            this.marks = m;
            this.left = null;
            this.right =  null;
            this.size = s;
        }
    }



    public void put(final Integer roll, final Name name, final Double mark) {
        if (roll == null) {
            return;
        }
        root = put(root, roll, name, mark);
    }

    private Node put(final Node x, final Integer roll, final Name name, final Double mark) {
        size++;
        if (x == null) {
            return new Node(roll, name, mark, 1);
        }
        int cmp = roll - x.roll;
        if (cmp < 0) {
            x.left  = put(x.left,  roll, name, mark);
        } else if (cmp > 0) {
            x.right = put(x.right, roll, name, mark);
        }
        //     x.name = val;
        // }
        x.size = 1 + size(x.left) + size(x.right);
        return x;


    }
      /**
     * size of the binary tree.
     * The time complexity is O(1).
     *
     *
     * @return     { int type }
     */

    public int size() {
        return size(root);
    }

    /**
     * return number of key-value pairs in BST rooted at x.
     * The time complexity is O(1).
     *
     *
     * @param      x     { Node type }
     *
     * @return     { int type }
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }

    public void marksBetween(Double lo, Double hi) {

        // Queue<Key> queue = new Queue<Key>();
        marksBetween(root, lo, hi);
        // return queue;
    }

    private void marksBetween(Node x, Double lo, Double hi) {
        if (x == null) return;
        Double cmplo = lo - x.marks;
        Double cmphi = hi - x.marks;
        if (cmplo < 0) marksBetween(x.left, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) System.out.println(x.name);
        if (cmphi > 0) marksBetween(x.right, lo, hi);
    }

    public void marksLess(Double lo, Double hi) {

        // Queue<Key> queue = new Queue<Key>();
        marksBetween(root, lo, hi);
        // return queue;
    }

    private void marksLess(Node x, Double lo, Double hi) {
        if (x == null) return;
        Double cmplo = lo - x.marks;
        Double cmphi = hi - x.marks;
        if (cmplo < 0) marksLess(x.left, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) System.out.println(x.name);
        if (cmphi > 0) marksLess(x.right, lo, hi);
    }

    public void marksGreater(Double lo, Double hi) {

        // Queue<Key> queue = new Queue<Key>();
        marksBetween(root, lo, hi);
        // return queue;
    }

    private void marksGreater(Node x, Double lo, Double hi) {
        if (x == null) return;
        Double cmplo = lo - x.marks;
        Double cmphi = hi - x.marks;
        if (cmplo < 0) marksGreater(x.left, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) System.out.println(x.name);
        if (cmphi > 0) marksGreater(x.right, lo, hi);
    }


    public Double max() {

        return max(root);
    }

    /**
     * The maximum node is found.
     * The time complexity is O(N).
     *
     *
     * @param      x     { Node type }
     *
     * @return     { returns maximum node}
     */

    private Double max(final Node x) {
        if (x.right == null) {
            return x.marks;
        } else {
            return max(x.right);
        }
    }




}
/**
 * Class for solution.
 */

final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * Reads input.
	 * The student data is stored and to get student information.
	 * we use binary search tree.
	 * The time complexity is average logarathmic value.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
        int lines = Integer.parseInt(input.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = input.nextLine().split(",");
            bst.put(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
        }
        int output = Integer.parseInt(input.nextLine());
        for (int i = 0; i < output; i++) {
            String[] tokens = input.nextLine().split(" ");
            switch (tokens[0]) {
            	case "BE":
            	bst.marksBetween(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            	break;
            	case "LE":
            	bst.marksLess(0.0, Double.parseDouble(tokens[1]));
            	break;
            	case "GE":
            	bst.marksGreater(Double.parseDouble(tokens[1]), bst.max());
            	break;
            	default:
            	break;
            }
        }
	}
}
