/**
 * class for team has 4 attributes.
 * name, win points, loose points, draw points.
 *
 */
class Team {
    /**
     * data type of name of the team is string.
     * data type of wins is int.
     * data type of loose is int.
     * data type of draw is int.
     */
    private String name;
    private int wins;
    private int losses;
    private int draws;
    /**
     * overloaded constuctor.
     */

    Team() {

    }
    /**
     * Constructs the object.
     *
     * @param      n     { name of string }
     * @param      w     { winning points }
     * @param      l     { loosing points }
     * @param      d     { draw points }
     */

    Team(String n, int w, int l, int d) {
        name = n;
        wins = w;
        losses = l;
        draws = d;
    }
    /**
     * getter method for name of the team.
     *
     * @return    returns name of type string.
     */

    public String getName() {
        return name;
    }
    /**
     * getter method for win points
     *
     * @return     returns win points of type int.
     */
    public int getWins() {
        return wins;
    }
    /**
     * getter method for loose points.
     *
     * @return     returns loose points of type int.
     */
    public int getLosses() {
        return losses;
    }
    /**
     * getter method for draw points.
     *
     * @return     returns draw points of type int.
     */

    public int getDraws() {
        return draws;
    }
}

class TeamArray {
    /**
     * teamArray is of type class-Team
     * The size of the teamArray is tracked by size.
     */
    private Team[] teamArray;
    private int size =0;

    /**
     * Constructs the object.
     * initializes size of the teamArray.
     */

    TeamArray() {
        teamArray = new Team[10];
    }

    /**
     * getter method for teamArray of type Team class.
     *
     * @return    returns TeamArray of type Team.
     */

    public Team[] getTeam() {
        return teamArray;
    }
    /**
     * \getter method for size of the teamArray.
     *
     * @return     returns the size of type int.
     */

    public int getSize() {
        return size;
    }

    /**
     * adds the object Team to teamArray
     *
     * @param      t     { t is object for Team class }
     */

    public void addTeam(Team t) {
         teamArray[size++] = t;
         // System.out.println(size);
    }
    /**
     * This method creates object for selection class and calls selection method.
     */

    public void get() {
        Selection selection = new Selection();
        selection.selectionSort(teamArray, size);

    }
    /**
     * method to print sorted array.
     *
     * @return     { The names of the teams ARE STORED in the string and the string is returned }
     */
     public String print() {
        String str = "";
        for(int i = 0; i<size; i++) {
        str += teamArray[i].getName()+",";
        }
        return str.substring(0, str.length()-1);
    }
}

/**
 * class for selection class.
 * In selection sort, we go to first index and iterate through entire array to find minimum element.
   If we find the minimum element, we swap the minimum element with element in first index.
   This process repeats.
   The time complexity for selection sort is also n^2.
   The for loop is iterated for two times.
 */



class Selection {
    /**
     * The exchange method exchanges two Teams in teamArray.
     *
     * @param      teamArray  The team array
     * @param      a          { index to be exchanged }
     * @param      b          { index to be exchanged }
     */

    public void exchange(Team[] teamArray, int a, int b) {
        Team temp = new Team();
        temp = teamArray[a];
        teamArray[a] = teamArray[b];
        teamArray[b] = temp;

    }

    /**
     * compares two team scores(win, loose, draw)
     *
     * @param      a     { int value of win or loose or draw }
     * @param      b     { int value of win or loose or draw}
     *
     * @return     { returns int (-1, 1, 0) }
     */

    public int compareTo(int a, int b) {
        if(a>b) {
            return +1;
        }
        if(a == b) {
            return 0;
        }
        return -1;
    }

    /**
     * method performs selection sort for the given array.
     *
     * @param      teamArray  The team array of type team class.
     * @param      size       The size of teamArray
     */


    public void selectionSort(Team[] teamArray, int size) {
    	for(int i = 0; i<size; i++) {
            int max = i;
    		for(int j = i+1; j<size; j++) {
    			if(compareTo(teamArray[j].getWins(), teamArray[i].getWins()) >0) {
    				max = j;
                    exchange(teamArray, i, max);
    			}

                else if(compareTo(teamArray[j].getWins(), teamArray[i].getWins()) == 0) {
                    if(compareTo(teamArray[j].getLosses(), teamArray[i].getLosses()) <0) {
                        max = j;
                        exchange(teamArray, i, max);
                        // break;
                    }
                     else if(compareTo(teamArray[j].getLosses(), teamArray[i].getLosses()) == 0) {
                        if(compareTo(teamArray[j].getDraws(), teamArray[i].getDraws()) >0) {
                        max = j;
                        exchange(teamArray, i, max);
                        // break;
                        }
                    }
                }
    		}
    	}

    }
}
