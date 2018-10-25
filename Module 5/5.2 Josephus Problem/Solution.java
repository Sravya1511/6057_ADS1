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
        int count = input.nextInt();
        for(int x = 0; x<count; x++) {
            Queue n = new Queue();
            // int count = input.nextInt();
            // int cut = input.nextInt();
            String[] tokens = input.nextLine().split(" ");

            for (int i = 0; i < Integer.parseInt(tokens[0]); i++) {
                n.enqueue(i);
            }
            String result = "";
            while (!n.isEmpty()) {
                int t2 = 0, t1 = 0;
                for (int i = 0; i < Integer.parseInt(tokens[1]); i++) {
                    if (i != Integer.parseInt(tokens[1]) - 1) {
                        t1 = n.dequeue();
                        n.enqueue(t1);
                    } else {
                        t2 = n.dequeue();
                    }
                }
                result += t2 + " ";
            }
            System.out.println(result.trim());
        }

        }
}

