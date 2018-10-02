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

    public void get() {
    	Insertion insertion = new Insertion();
    	insertion.insertionSort(teamArray, size);

    }
     public String print() {
    	String str = "";
    	for(int i = 0; i<size; i++) {
   	    str += teamArray[i].name+",";
	    }
	    return str.substring(0, str.length()-1);
    }
}

class Insertion {

	public void exchange(Team[] teamArray, int a, int b) {
    	Team temp = new Team();
    	temp = teamArray[a];
    	teamArray[a] = teamArray[b];
    	teamArray[b] = temp;

    }

    public int compareTo(int a, int b) {
    	if(a>b) {
    		return +1;
    	}
    	if(a == b) {
    		return 0;
    	}
    	return -1;
    }

    public void insertionSort(Team[] teamArray, int size) {
    	for(int i = 0; i<size; i++) {
    		for(int j = i; j>0; j--) {
    			if (compareTo(teamArray[j].wins, teamArray[j-1].wins) >0) {
    				exchange(teamArray, j, j-1);
    			}
    			if (compareTo(teamArray[j].wins, teamArray[j-1].wins) == 0) {
                    if(compareTo(teamArray[j].losses, teamArray[j-1].losses) < 0) {
    				exchange(teamArray, j, j-1);
    			    }
    			    if(compareTo(teamArray[j].losses, teamArray[j-1].losses) == 0) {
    				    if(compareTo(teamArray[j].draws, teamArray[j-1].draws) >0 ) {
    				    exchange(teamArray, j, j-1);
    			        }
    			    }
    			}

    		}
    	}
    }

}



class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		TeamArray teamArr = new TeamArray();
		int c = 0;
		while(input.hasNext()) {
			String[] token = input.nextLine().split(",");
			teamArr.addTeam(new Team(token[0], Integer.parseInt(token[1]),
				Integer.parseInt(token[2]),
				Integer.parseInt(token[3])));
			c++;
		}
		teamArr.get();
        System.out.println(teamArr.print());

	}
}