import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { v }.
     */
    private WeightedQuickUnionUF u;
    /**
     * { var_description }.
     */
    private boolean[][] arr;
    // private int[] arr_1;
     /**
     * { var_description }.
     */
    private int size;

    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */

    Percolation(final int n) {
        arr = new boolean[n][n];
        // arr_1 = new int[n*n];
        u = new WeightedQuickUnionUF(n * n + 2);
        size = n;
    }
    /**
     * { function_description }.
     *
     * @param      row   The row
     * @param      col   The col
     */

    public void open(final int row, final int col) {
        if (arr[row][col]) {
            return;
        }
        arr[row][col] = true;
        // opensites++;
        if (col + 1 < size && isOpen(row, col + 1)) {
            u.union(row * size + col, row * size + (col + 1));
        }
        if (row + 1 < size && isOpen(row + 1, col)) {
            u.union(row * size + col, (row + 1) * size + col);

        }
        if(col - 1 >= 0 && isOpen(row, col - 1)) {
            u.union(row * size + col, row * size + (col - 1));

        }
        if (row - 1 >= 0 && isOpen(row - 1, col)) {
            u.union(row * size + col, (row - 1) * size + col);
        }
        if (row == 0) {
            u.union(col, size * size);
        }
        if (row == size - 1) {
            u.union(row * size + col, (size * size) + 1);
        }
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */

    public boolean isOpen(final int row, final int col) {
        return arr[row][col];

    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */

    public boolean percolates() {
        return u.connected(size * size, size * size + 1);
    }
}
/**
 * { item_description }.
 */

public class Solution {
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Percolation p = new Percolation(n);
        while (input.hasNext()) {
            p.open(input.nextInt() - 1, input.nextInt() - 1);
        }
        System.out.println(p.percolates());
    }
}