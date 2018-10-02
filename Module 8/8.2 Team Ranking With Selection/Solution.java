import java.util.Scanner;

class Team {
	String name;
	int wins;
	int losses;
	int draws;

	Team() {

	}

    Team(String n, int w, int l, int d) {
    	name = n;
    	wins = w;
    	losses = l;
    	draws = d;
    }
}

class TeamArray {
	Team[] teamArray;
	int size =0;

	TeamArray() {
		teamArray = new Team[10];
	}

	public void addTeam(Team t) {
         teamArray[size++] = t;
         // System.out.println(size);
    }

    public void exchange(int a, int b) {
    	Team temp = new Team();
    	temp = teamArray[a];
    	teamArray[a] = teamArray[b];
    	teamArray[b] = temp;

    }

    public void SelectionSort() {
    	for(int i = 0; i<size; i++) {
            // int min = i;
    		for(int j = i+1; j<size; j++) {
    			if(teamArray[j].wins > teamArray[i].wins) {
    				// min = j;
                    exchange(i, j);
    			}

                else if(teamArray[j].wins == teamArray[i].wins) {
                    if(teamArray[j].losses < teamArray[i].losses) {
                        // min = j;
                        exchange(i, j);
                        // break;
                    }
                     else if(teamArray[j].losses == teamArray[i].losses) {
                        if(teamArray[j].draws > teamArray[i].draws) {
                        // min = j;
                        exchange(i, j);
                        // break;
                        }
                    }
                }


    		}
    	}
    }


    public String print() {
    	String str = "";
    	for(int i = 0; i<size; i++) {
   	    str += teamArray[i].name+",";
	    }
	    return str.substring(0, str.length()-1);
    }
}






class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TeamArray teamArr = new TeamArray();
		while(input.hasNext()) {
			String[] token = input.nextLine().split(",");
			teamArr.addTeam(new Team(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3])));
		}
        teamArr.SelectionSort();
        System.out.println(teamArr.print());

	}
}