import java.util.Scanner;
/**
 * Class for solution.
 * reads input.
 * The object for stock class is created.
 *
 */

final class Solution {
	/**
	 * Constructs the object.
	 */

	private Solution() {

	}
	/**
	 * The main method puts all the stocks in min.
	 * heap and max heap.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		final int six = 6;
		final int t = 30;
		final int five = 5;

		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		SymbolTable<String, Integer> symbolMax = new
		SymbolTable<String, Integer>(t);
		SymbolTable<String, Integer> symbolMin = new
		SymbolTable<String, Integer>(t);

		for (int i = 0; i < six; i++) {
			MinPQ<Stock> stMinPQ = new MinPQ<Stock>();
			MaxPQ<Stock> stMaxPQ = new MaxPQ<Stock>();
			for (int j = 0; j < n; j++) {
				String[] tokens = input.nextLine().split(",");
				stMinPQ.insert(new Stock(tokens[0],
					Float.parseFloat(tokens[1])));
				// set.add(tokens[0]);
				stMaxPQ.insert(new Stock(tokens[0],
					Float.parseFloat(tokens[1])));
				// set.add(tokens[0]);
			}
			for (int k = 0; k < five; k++) {
				Stock a = stMaxPQ.delMax();
				System.out.println(a);
				symbolMax.put(a.name, 1);
			}
			System.out.println();
			for (int k = 0; k < five; k++) {
				Stock b = stMinPQ.delMin();
				System.out.println(b);
				symbolMin.put(b.name, 1);
			}
			System.out.println();
		}
        // System.out.println("Max SymbolTable");
		// symbolMax.print();
		// System.out.println("Min SymbolTable");
		// symbolMin.print();
		//
		int k = Integer.parseInt(input.nextLine());
		for (int i = 0; i < k; i++) {
			String[] tokens = input.nextLine().split(",");
			switch(tokens[0]) {
				case "get":
				if (tokens[1].equals("maxST")) {
		System.out.println(symbolMax.get(tokens[2]));
				}
				if (tokens[1].equals("minST")) {
		System.out.println(symbolMin.get(tokens[2]));
				}
				break;
                case "intersection":
                symbolMax.intersection(symbolMin.getKeys(),
                	symbolMax.getKeys());
                break;
                default:
                break;

			}
		}
	}
}

