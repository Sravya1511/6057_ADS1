import java.util.Scanner;

class Team {
	private String name;
	private int wins;
	private int losses;
	private int draws;

	Team() {

	}

    Team(String n, int w, int l, int d) {
    	name = n;
    	wins = w;
    	losses = l;
    	draws = d;
    }

    public String getName() {
    	return name;
    }
    public int getWins() {
    	return wins;
    }
    public int getLosses() {
    	return losses;
    }

    public int getDraws() {
    	return draws;
    }
}

class TeamArray {
	private Team[] teamArray;
	private int size =0;

	TeamArray() {
		teamArray = new Team[10];
	}

	public Team[] getTeam() {
		return teamArray;
	}

	public int getSize() {
		return size;
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
   	    str += teamArray[i].getName()+",";
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
    			if (compareTo(teamArray[j].getWins(), teamArray[j-1].getWins()) >0) {
    				exchange(teamArray, j, j-1);
    			}
    			if (compareTo(teamArray[j].getWins(), teamArray[j-1].getWins()) == 0) {
                    if(compareTo(teamArray[j].getLosses(), teamArray[j-1].getLosses()) < 0) {
    				exchange(teamArray, j, j-1);
    			    }
    			    if(compareTo(teamArray[j].getLosses(), teamArray[j-1].getLosses()) == 0) {
    				    if(compareTo(teamArray[j].getDraws(), teamArray[j-1].getDraws()) >0 ) {
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