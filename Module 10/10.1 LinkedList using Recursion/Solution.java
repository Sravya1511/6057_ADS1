import java.util.Scanner;
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
	 * the object for linkedlist class is created.
	 * The insertAt method and reverse methods are called.
	 *
	 * @param      args  The arguments
	 */

    public static void main(final String[] args) {
    	LinkedList list = new LinkedList();
    	Scanner input = new Scanner(System.in);
    	while(input.hasNext()) {
    		String[] token = input.nextLine().split(" ");
    		switch (token[0]) {
    			case "insertAt":
    			int size = list.size();
    			int position = Integer.parseInt(token[1]);
    			if (position < 0 || position > size) {
    				System.out.println("Can't insert at this position.");
    			} else {
                    list.insertAt(position, Integer.parseInt(token[2]));
    			    System.out.println(list.print());
    			}
    			break;
    			case "reverse":
    			if (list.size() == 0) {
    				System.out.println("No elements to reverse.");
    			} else {
    				list.reverse();
    				System.out.println(list.print());
    			}
    			break;
    			default:
    			break;
    		}
    	}
    }
}
