
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

        private RollNum roll;

        private Name name;

        private Double marks;
        private Node left;

        private Node right;

        private int size;

        Node(final RollNum k, final Name v, final Double m, final int s) {
            this.roll = k;
            this.name = v;
            this.marks = m;
            this.left = null;
            this.right =  null;
            this.size = s;
        }
    }



    public void put(final RollNum roll, final Name name, final Double mark) {
        if (roll == null) {
            return;
        }
        root = put(root, roll, name, mark);
    }

    private Node put(final Node x, final RollNum roll, final Name name, final Double mark) {
        size++;
        if (x == null) {
            return new Node(roll, name, mark, 1);
        }
        Double cmp = mark - x.marks;
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

    public void marksLess(Double mark) {

        // Queue<Key> queue = new Queue<Key>();
        marksLess(root, mark);
        // return queue;
    }

    private void marksLess(Node x, Double lo) {
        if (x == null) return;
        Double cmplo = lo - x.marks;
        // Double cmphi = hi - x.marks;
        if (cmplo < 0) marksLess(x.left, lo);
        if (cmplo <= 0) System.out.println(x.name);
        if (cmplo > 0) marksLess(x.right, lo);
    }

    public void marksGreater(Double mark) {

        // Queue<Key> queue = new Queue<Key>();
        marksGreater(root, mark);
        // return queue;
    }

    private void marksGreater(Node x, Double hi) {
        if (x == null) return;
        // Double cmplo = lo - x.marks;
        Double cmphi = hi - x.marks;
        if (cmphi < 0) marksGreater(x.left, hi);
        if (cmphi >= 0) System.out.println(x.name);
        if (cmphi > 0) marksGreater(x.right, hi);
    }


}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
        int lines = Integer.parseInt(input.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = input.nextLine().split(",");
            bst.put(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
        }
        int output = Integer.parseInt(input.nextLine());
        for (int i = 0; i < output; i++) {
            String[] tokens = input.nextLine().split(" ");
            switch (tokens[0]) {
            	case "BE":
            	bst.marksBetween(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            	break;
            	case "LE":
            	bst.marksLess(Double.parseDouble(tokens[1]));
            	break;
            	case "GE":
            	bst.marksGreater(Double.parseDouble(tokens[1]));
            	break;
            }
        }
	}
}
