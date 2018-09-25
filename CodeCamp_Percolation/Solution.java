import java.util.*;
class Percolation {
    private WeightedQuickUnionUF u;
    private boolean[][] arr_2;
    // private int[] arr_1;
    private int size;

    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */

    public Percolation(int n) {
        arr_2 = new boolean[n][n];
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

    public void open(int row, int col) {
        if (arr_2[row][col]) return;
        arr_2[row][col] = true;
        // opensites++;
        if (col + 1 < size && isOpen(row, col + 1)) {
            u.union(row * size + col, row * size + (col + 1));
        }
        if (row + 1 < size && isOpen(row + 1, col)) {
            u.union(row * size + col, (row + 1) * size + col);

        }
        if(col - 1 >= 0 && isOpen(row, col - 1)){
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

    public boolean isOpen(int row, int col) {
        return arr_2[row][col];

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

public final class Solution {
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Percolation p = new Percolation(n);
        while (input.hasNext()) {
            p.open(input.nextInt() - 1, input.nextInt() - 1);
        }
        System.out.println(p.percolates());
    }
}