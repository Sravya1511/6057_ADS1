
import java.util.Scanner;

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
     * The time complexity is O(NlogN).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int lines = Integer.parseInt(input.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = input.nextLine().split(",");
            bst.put(Integer.parseInt(tokens[0]),
                tokens[1], Double.parseDouble(tokens[2]));
        }
        int output = Integer.parseInt(input.nextLine());
        for (int i = 0; i < output; i++) {
            String[] tokens = input.nextLine().split(" ");
            switch (tokens[0]) {
                case "BE":
                bst.marksBetween(Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]));
                break;
                case "LE":
                bst.marksLess(0.0, Double.parseDouble(tokens[1]));
                break;
                case "GE":
                bst.marksGreater(Double.parseDouble(tokens[1]),
                    bst.max());
                break;
                default:
                break;
            }
        }
    }
}
