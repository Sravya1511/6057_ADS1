import java.util.Scanner;
// import java.util.Comparator;
// import java.util.Arrays;
/**
 * Class for minpq
 * this class checks if the elements are inserted in binary heap order or not.
 * The time complexity is O(logN).
 The key node is searched by N/2.
 *
 * @param      <E>   { array of generic type }
 */
class MinPQ<E extends Comparable<E>> {
    /**
     * pq array of generic type.
     */
    private E[] pq;
     /**
      * Constructs the object.
      *
      * @param      array  The array of generic type.
      */

    MinPQ(final E[] array) {
     pq = array;

    }
    /**
     * The method determines if the array is minimum priority queue or not.
     * The time complexity is O(logN).
     *
     * @return     True if minimum heap, False otherwise.
     */

    public boolean isMinHeap() {
        int n = pq.length - 1;
          while (n > 1) {
            if (pq[n].compareTo(pq[n / 2]) >= 0) {
                n = -1;
            } else {
                return false;
            }
          }
          return true;
    }
}
/**
 * Class for solution.
 * Time complexity is O(N)
 */

final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads input.
     * creates object for minpq class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        int n = Integer.parseInt(input.nextLine());
        switch (type) {
            case "String":
            for (int i = 0; i < n; i++) {

                String[] tokens = input.nextLine().split(",");

                String[] res = new String[tokens.length + 1];
                // int m = 1;
                for (int k = 0; k < tokens.length; k++) {
                      res[k + 1] = tokens[k];

                }

    MinPQ<String> stringArray = new MinPQ<String>(res);
        System.out.println(stringArray.isMinHeap());
            }
            break;
            case "Integer":
            for (int i = 0; i < n; i++) {

                String[] tokens = input.nextLine().split(",");
                Integer[] res = new Integer[tokens.length + 1];
                // int m = 1;
                for (int k = 0; k < tokens.length; k++) {
                      res[k + 1] = Integer.parseInt(tokens[k]);

                }
        MinPQ<Integer> intArray = new MinPQ<Integer>(res);
        System.out.println(intArray.isMinHeap());
            }
            break;
            case "Float":
            for (int i = 0; i < n; i++) {
                String temp = input.nextLine();
                String[] tokens = temp.split(",");
                // System.out.println(tokens[]);
                if (tokens[0].equals("")) {
                    System.out.println("false");
                    // System.out.println("hi");
                    return;
                }
                Float[] res = new Float[tokens.length + 1];
                int m = 1;
            for (int k = 0; k < tokens.length; k++) {
                      res[m] = Float.parseFloat(tokens[k]);
                      m++;
                }
                MinPQ<Float> flArray = new MinPQ<Float>(res);
                System.out.println(flArray.isMinHeap());
            }
            break;
            case "Double":
            for (int i = 0; i < n; i++) {
                String[] tokens = input.nextLine().split(",");
                Double[] res = new Double[tokens.length + 1];
                int m = 1;
                for (int k = 0; k < tokens.length; k++) {
                      res[m] = Double.parseDouble(tokens[k]);
                      m++;
                }
            MinPQ<Double> doubleArray = new MinPQ<Double>(res);
            System.out.println(doubleArray.isMinHeap());
            }
            break;
            default:
            break;
        }
    }
}