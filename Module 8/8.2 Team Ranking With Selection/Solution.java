import java.util.Scanner;

/**
 *
 * reads input.
 * Class for solution.
 */
class Solution {
    /**
     * The object for Team class is created.
     * and the method add adds the team into team Array.
     *
     *
     * @param      args  The arguments
     */
	public static void main(String[] args) {
        /**
         * The sorting method is called.
         */
		Scanner input = new Scanner(System.in);
		TeamArray teamArr = new TeamArray();
		while(input.hasNext()) {
			String[] token = input.nextLine().split(",");
			teamArr.addTeam(new Team(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3])));
		}
        teamArr.get();
        System.out.println(teamArr.print());

	}
}