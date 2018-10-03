import java.util.Arrays;
import java.util.Scanner;
class Insertion {

    public boolean less(Comparable a, Comparable b) {
       return a.compareTo(b) < 0;
   }
   public void insertionSort(Comparable[] array) {
    System.out.println("Insertion sort method invoked...");
    int size = array.length;
        for(int i = 0; i<size; i++) {
            for(int j = i; j>0; j--) {
                if(less(array[j], array[j-1])) {
                    Comparable temp = 0;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

}
class MergeSort {


    public boolean less(Comparable a, Comparable b) {
    	return a.compareTo(b) < 0;
    }

    public boolean isSort(Comparable[] array) {
        for(int i = 1; i<array.length; i++) {
            if(!less(array[i-1], array[i])) {
                return false;
            }
        }
        return true;
    }

    public void sort(Comparable[] array, Comparable[] aux, int low, int high) {
    	if (low >= high) {
    		return;
    	}
    	int mid = low+(high-low)/2;
        if(high-low <= 7) {
        Insertion insertion = new Insertion();
        insertion.insertionSort(array);
        if(isSort(array)) {
            System.out.println("Array is already sorted. So, skipped the call to merge...");
            return;
        }
        }

        // if(mid-low < 7 && array.length >7) {
        // Insertion insertion = new Insertion();
        // // System.out.println("Insertion sort method invoked...");
        // insertion.insertionSort(array, mid-low);

        // }
        // if(high-mid < 7 && array.length >7) {
        // Insertion insertion = new Insertion();
        // // System.out.println("Insertion sort method invoked...");
        // insertion.insertionSort(array, high-mid);


        // }
        else {
        sort(array, aux, low, mid);
        sort(array, aux, mid+1, high);
        merge(array, aux, low, mid, high);
        }


    }

    public void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
    	for(int i = low; i<=high; i++) {
    		aux[i] = array[i];
    	}
    	int i = low;
    	int j = mid+1;
    	for(int k = low; k<=high; k++) {
    	if (i > mid)
            array[k] = aux[j++];
        else if (j > high)
            array[k] = aux[i++];
        else if (less(aux[j], aux[i]))
            array[k] = aux[j++];
        else  array[k] = aux[i++];
    	}

    }
}

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
        String [] token = input.nextLine().split(",");
        int size = token.length;
        Comparable[] aux = new Comparable[size];
        MergeSort merge = new MergeSort();
        merge.sort(token, aux, 0, token.length-1);
        System.out.println(Arrays.toString(token));
        System.out.println();
        }


    }
}