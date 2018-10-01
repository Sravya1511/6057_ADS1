import java.util.Scanner;
/**
 * Class for solution.
 * reads input.
 * creates object for Steque.
 * performs methods in Steque.
 */

class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		for (int i = 0; i < n; i++) {
			Steque list = new Steque();
			while(input.hasNext()) {
				String[] token = input.nextLine().split(" ");
				if(token[0].equals("")) {
					break;
				}
				switch(token[0]) {
					case "push":
					list.push(Integer.parseInt(token[1]));
					list.print();
					break;
					case "pop":
					if(list.pop()) {
					list.print();
					}
					else {
						System.out.println("Steque is empty.");
					}
					break;
					case "enqueue":
					list.enqueue(Integer.parseInt(token[1]));
					list.print();
					break;
				}
			}
			System.out.println();
		}

	}
}