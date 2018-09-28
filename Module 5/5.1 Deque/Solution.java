import java.util.Scanner;
/**
 * Class for solution.
 * reads input.
 */

class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method is written
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Deque deque = new Deque();
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split(" ");
            switch(tokens[0]) {
                case "pushLeft":
                deque.pushLeft(Integer.parseInt(tokens[1]));
                deque.print();
                break;
                case "pushRight":
                deque.pushRight(Integer.parseInt(tokens[1]));
                deque.print();
                break;
                case "popRight":
                if (deque.popRight()) {
                deque.print();
                } else {
                System.out.println("Deck is empty");
                }
                break;
                case "popLeft":
                if (deque.popLeft()) {
                deque.print();
                } else {
                System.out.println("Deck is empty");
                }
                break;
                case "size":
                System.out.println(deque.size());
                break;
                case "isEmpty":
                if (deque.isEmpty()) {
                    System.out.println("empty");
                } else {
                 System.out.println("Not empty");
                }
                break;


            }
        }
    }

}