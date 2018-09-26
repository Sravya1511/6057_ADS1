import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = Integer.parseInt(input.nextLine());
		int b = Integer.parseInt(input.nextLine());
		String[] t = input.nextLine().split(",");
		String[] s = input.nextLine().split(",");
		int[] array1;
		array1 = new int[t.length];
		int[] array2;
		array2 = new int[s.length];
		for(int i = 0; i<t.length; i++) {
			array1[i] = Integer.parseInt(t[i]);
		}
		for(int i = 0; i<s.length; i++) {
			array2[i] = Integer.parseInt(s[i]);
		}
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		sort(array1, array2);

	}

	public static void sort(int[] array1, int[] array2) {
		int i = 0;
		int j = 0;
		int [] result;
		result = new int[array1.length+array2.length];
		for(int k = 0; k<result.length; k++) {
			if(i<array1.length && j<array2.length) {
				if(array1[i] < array2[j]) {
					result[k] = array1[i++];
				}
				else
					result[k] = array2[j++];
			}
			else if(i>=array1.length) {
				result[k] = array2[j++];
			}
			else if(j>=array2.length) {
				result[k] = array1[i++];
			}
		}
		System.out.println(Arrays.toString(result).replace("[", "").replace("]","").replace(" ",""));
	}

}