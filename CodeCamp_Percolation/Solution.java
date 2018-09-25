import java.util.*;
class Percolation {
	private int arr_2[][];
	private int arr_1[];
	// create n-by-n grid, with all sites blocked
	Percolation(int n) {
     arr_2 = new int[n][n];
     arr_1 = new int[n*n];
	}
    public void percolation(int n) {


		// for(int i = 0; i<n; i++) {
		// 	for(int j = 0; j<n; j++) {
		// 		arr_2[i][j] = 0;
		// 	}
		// }
		// for(int i = 0; i<n; i++)
		// System.out.println(Arrays.toString(arr_2[i]));


		for(int i = 0; i<n*n; i++) {
			arr_1[i] = i;
		}
		// System.out.println(Arrays.toString(arr_1));
    }
      // open site (row, col) if it is not open already
      public void open(int row, int col, int n)   {
      	arr_2[row-1][col-1] = 1;
      	int i = row-1;
      	int j = col-1;
      	      }
      // is site (row, col) open?
      public boolean isOpen(int row, int col) {
      	return arr_2[row-1][col-1] == 1;

      }
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    // does the system percolate?
    // public boolean percolates()  {
    // 	for
    // }
    public void solution(int n) {
    	// for(int i = 0; i<n; i++) {
    	// 	System.out.println(Arrays.toString(arr_2[i]));
    	// }
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			if(arr_2[i][j] == 1) {
    				if (j < n-1) {
    					if(arr_2[i][j+1] == 1){
    						union(i*n+j, i*n+j+1);
    					}
    				}
    				if (i < n-1) {
                        if(arr_2[i+1][j] == 1) {
    						union(i*n+j, (i+1)*n+j);
    					}
    				}
    				if(i>0) {
    					if(arr_2[i-1][j] == 1) {
    						union(i*n+j, (i-1)*n+j);
    					}
    				}

    				if(j>0) {
    					if(arr_2[i][j-1] == 1) {
    						union(i*n+j, i*n+j-1);
    					}
    				}



    			}
    		}
    	}
    	// System.out.println(Arrays.toString(arr_1));
    }
    // public boolean connected(int p, int q) {
    //     return find(p) == find(q);
    // }
    // public int find(int p) {
    //     validate(p);
    //     while (p != parent[p])
    //         p = parent[p];
    //     return p;
    // }

    public boolean percolates(int n) {
    	int i = 0;
    	int j = n*n-n;
    	while(i<n && j<n*n) {
    		// System.out.println("h");

    		if (root(arr_1[i]) == root(arr_1[j])) {
    			// System.out.println("i");
    			return true;
    		}
    		else {
    			i++;
    			j++;
    		}
    	}
    	return false;

    }
    public int root(int i) {
    	while(i!=arr_1[i])
    		i = arr_1[i];
    	return i;

    }
    public void union(int p, int q)   {
    	int i = root(p);
    	int j = root(q);
    	arr_1[i] = j;
    }
}



// You can implement the above API to solve the problem
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		Percolation p = new Percolation(n);
		p.percolation(n);
	while(input.hasNext()) {
		String[] token = input.nextLine().split(" ");
		p.open(Integer.parseInt(token[0]), Integer.parseInt(token[1]), n);
	}
		// p.solution(n);
		System.out.println(p.percolates(n));
	}
}


