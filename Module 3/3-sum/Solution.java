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
	public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
               return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present
        //  in array
        return -1;
    }
	public static void threesum(int[] array, int n) {
		// System.out.println(Arrays.toString(array));
        int count = 0;
		for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // int k = binarySearch(array, -(array[i] + array[j]));
                // if (k > j) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                // int sum = array[i] + array[j] + k;
                int a = array[i] + array[j];
                int k = binarySearch(array, 0, n, -a);
                // if (k>j) {
                // 	count++;
                // }
                if (a+k == 0) {
                	count++;
                }
            }
        }

		System.out.println(count);
	}
}