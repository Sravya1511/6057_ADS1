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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { var_description }
         */
        Scanner input = new Scanner(System.in);
        LinkedList stack = new LinkedList();
        String[] n = input.nextLine().split(" ");
        for (int i = 0; i < n.length; i++) {
            switch (n[i]) {
                case "+":
                int res = stack.pop() + stack.pop();
                stack.push(res);
                break;
                case "-":
                int res1 = stack.pop() - stack.pop();
                stack.push(res1);
                break;
                case "*":
                int res2 = stack.pop() * stack.pop();
                stack.push(res2);
                break;
                case "/":
                int res3 = stack.pop() / stack.pop();
                stack.push(res3);
                break;
                default:
                stack.push(Integer.parseInt(n[i]));
                break;

            }
        }
        System.out.println(stack.pop());
    }
}