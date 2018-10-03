import java.util.Arrays;
import java.util.Scanner;
class Insertion {

     public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
     public  void insertionSort(Comparable[] array, int size) {
        System.out.println("Insertion sort method invoked...");
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

    public void sort(Comparable[] array, Comparable[] aux, int low, int high) {
    	if (low >= high) {
    		return;
    	}
    	int mid = low+(high-low)/2;
        if(mid-low < 7) {
        Insertion insertion = new Insertion();
        insertion.insertionSort(array, mid-low);

        }
        else if(high-mid < 7) {
        Insertion insertion = new Insertion();
        insertion.insertionSort(array, high-mid);


        }
        else {
        sort(array, aux, low, mid);
        sort(array, aux, mid+1, high);
        }

    	merge(array, aux, low, mid, high);
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
        Integer [] array = new Integer[token.length];
        for(int i = 0; i<token.length; i++) {
            array[i] = Integer.parseInt(token[i]);

        }
        int size = array.length;
        Comparable[] aux = new Comparable[size];
        MergeSort merge = new MergeSort();
        merge.sort(array, aux, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        }


    }
}