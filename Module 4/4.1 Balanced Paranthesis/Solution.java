import java.util.Scanner;
/**
 * Class for stack array.
 */

final class StackArray {
    /**
     * string array to perform stack operations.
     */
    private String[] array;
    /**
     * size of stack array.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */

    StackArray(final int n) {
        array = new String[n];
        size = 0;
    }
    /**
     * pushes element into the stack.
     *
     * @param      item  The item
     */

    public void push(final String item) {
        array[size++] = item;
    }
    /**
     * removes top most element.
     */

    public void pop() {
        array[size - 1] = null;
        size--;
    }
    /**
     * checks if stack is empty or not.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
            return false;

    }
    /**
     * returns top most element.
     *
     * @return     { description_of_the_return_value }
     */
    public String peek() {
        int a = size - 1;
        return array[a];
    }
}
/**
 * Class for solution.
 * reads input.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scn = new Scanner(System.in);
        int lines = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = scn.nextLine().split("");
            paranthesis(tokens);
        }
    }
    /**
     * creates obj for StackArray class.
     *
     * @param      tokens  The tokens
     */

    public static void paranthesis(final String[] tokens) {
        boolean x = false;
        String i = ")";
        String j = "]";
        String k = "}";
        StackArray str = new StackArray(tokens.length);
        for (int m = 0; m < tokens.length; m++) {
if (tokens[m].equals(i) || tokens[m].equals(j) || tokens[m].equals(k)) {
                if (str.isEmpty()) {
                    System.out.println("NO");
                    x = true;
                    break;
                }
                String a = str.peek();
                // System.out.println(a);
if (a.equals("(") && (tokens[m].equals("]") || tokens[m].equals("}"))) {
                    System.out.println("NO");
                    x = true;
                    break;
                }
if (a.equals("{") && (tokens[m].equals("]") || tokens[m].equals(")"))) {
                    System.out.println("NO");
                    x = true;
                    break;
                }
if (a.equals("[") && (tokens[m].equals(")") || tokens[m].equals("}"))) {
                    System.out.println("NO");
                    x = true;
                    break;
                }
                str.pop();
            } else {
                    str.push(tokens[m]);
                }
            }
            // System.out.println(str);
            if (!x) {
                if (str.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
