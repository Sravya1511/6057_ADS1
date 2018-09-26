import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] array;
		array = new int[n];
		for(int i= 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		Arrays.sort(array);
		threesum(array, n);
	}

	public static void threesum(int[] array, int n) {
		// System.out.println(Arrays.toString(array));
        int count = 0;
		for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = Arrays.binarySearch(array, -(array[i] + array[j]));
                // if (k > j) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                // int sum = array[i] + array[j] + k;
                // int a = array[k]
                if(array[i] + array[j]+array[k] == 0)
                	count++;

            }
        }

		System.out.println(count);
	}
}