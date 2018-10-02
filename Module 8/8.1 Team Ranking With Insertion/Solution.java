import java.util.Scanner;

/**
 * Solution class reads input and creates object for TeamArray.
 */
final class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {

    }
    /**
     * the TeamArray object is created and addTeam method is called.
     * Get method is also called which performs insertion sort.
     * Finally, the sorted team names are printed.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);

        TeamArray teamArr = new TeamArray();
        int c = 0;
        final int three = 3;
        while (input.hasNext()) {
            String[] token = input.nextLine().split(",");
        teamArr.addTeam(new Team(token[0], Integer.parseInt(token[1]),
                Integer.parseInt(token[2]),
                Integer.parseInt(token[three])));
            c++;
        }
        teamArr.get();
        System.out.println(teamArr.print());

    }
}