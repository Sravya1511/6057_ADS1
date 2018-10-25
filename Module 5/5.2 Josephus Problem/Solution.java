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
        int line = input.nextInt();
        for(int x = 0; x<line; x++) {
            Queue n = new Queue();
            int count = input.nextInt();
            int cut = input.nextInt();

            for (int i = 0; i < count; i++) {
                n.enqueue(i);
            }


            String result = "";
            while (!n.isEmpty()) {
                int t2 = 0, t1 = 0;
                for (int i = 0; i < cut; i++) {
                    if (i != cut - 1) {
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

