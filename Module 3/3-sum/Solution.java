import java.util.*;
class solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] array;
		array = new int[n];
		for(int i= 0; i<n; i++) {
			array[i] = input.nextInt();
		}
		Arrays.sort(array);
		threesum(array, n);
	}

	public static void threesum(int[] array, int n) {
		// System.out.println(Arrays.toString(array));

		int count = 0;
		for(int i = 0; i<n-2; i++) {
			// System.out.println("a");
			for(int j = i+1; j<n-1; j++) {
				int sum = 0;
				// System.out.println(sum);
				for(int k = j+1; k<n; k++) {
					sum = array[i]+array[j]+array[k];
					// System.out.println(sum);
					if(sum == 0) {
						count++;
						break;
					}
				}
			}

		}
		System.out.println(count);
	}
}