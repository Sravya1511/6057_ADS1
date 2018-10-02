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

    public void InsertionSort() {
    	for(int i = 0; i<size; i++) {
    		for(int j = i; j>0; j--) {
    			if(teamArray[j].wins > teamArray[j-1].wins) {
    				exchange(j, j-1);
    			}
    			if(teamArray[j].wins == teamArray[j-1].wins) {
                   if(teamArray[j].losses < teamArray[j-1].losses) {
    				exchange(j, j-1);
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
	    return str;
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
        teamArr.InsertionSort();
        System.out.println(teamArr.print());

	}
}