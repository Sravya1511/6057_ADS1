import java.util.Scanner;
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        /**
         * reads input.
         */
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            CircularQueue counter = new CircularQueue();
            String[] tokens = input.nextLine().split(" ");
            int number = Integer.parseInt(tokens[0]);
            for (int j = 0; j < number; j++) {
                counter.insert(j);
            }
            String string = "";
            while (!counter.isEmpty()) {
                int element = 0;
                for (int k = 0; k < Integer.parseInt(tokens[1]); k++) {
                    element = counter.getElement();
                }
                string += counter.remove(element) + " ";
            }
            System.out.println(string.trim());
        }
    }
}
