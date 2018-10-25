import java.util.Scanner;
/**
 * Class for solution.
 *
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 *
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
	    Scanner input = new Scanner(System.in);
        String[] tokens = input.nextLine().split(" ");
        int m = Integer.parseInt(tokens[0]);
        int n = Integer.parseInt(tokens[1]);
        String[] magazine = input.nextLine().split(" ");
        String[] note = input.nextLine().split(" ");
        SeparateChainingHashST<String, Integer> mag = new SeparateChainingHashST<String, Integer>();
        SeparateChainingHashST<String, Integer> notes = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; i < m; i++) {
            mag.put(magazine[i], 0);
        }
        for (int j = 0; j < n; j++) {
            notes.put(note[j], 0);
        }
        for (int i = 0; i < m; i++) {
            int count = mag.get(magazine[i]);
            if (mag.contains(magazine[i])) {
                mag.put(magazine[i], count + 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!mag.contains(note[j])) {
                System.out.println("No");
                return;
            } else if (mag.contains(note[j])) {
                int num = notes.get(note[j]);
                if (notes.contains(note[j])) {
                    notes.put(note[j], num + 1);
                } else {
                    notes.put(note[j], 1);
                }
                if (notes.get(note[j]) > mag.get(note[j])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
	}
}

