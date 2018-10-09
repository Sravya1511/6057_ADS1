import java.util.Scanner;
/**
 * Class for dynamic median.
 */
class DynamicMedian {
    /**
     *the object to access of minheap.
     */
    private MinPQ<Double> minObj;
    /**
     *the object to access of maxheap.
     */
    private MaxPQ<Double> maxObj;
    /**
     *the constructor for initializing.
     */
    DynamicMedian() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    /**
     *the method will insert the element
     *to minheap.
     * @param      item  The item
     */
    public void insertAtMin(final double item) {
        minObj.insert(item);
    }
    /**
     *the method will insert the element
     *to maxheap.
     * @param      item  The item
     */
    public void insertAtMax(final double item) {
        maxObj.insert(item);
    }
    /**
     *this method gets the minimum element.
     * from minheap.
     * @return     The minimum.
     */
    public double getMin() {
        return minObj.min();
    }
    /**
     *this method gets the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double getMax() {
        return maxObj.max();
    }
    /**
     *this method delete the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double delMax() {
        return maxObj.delMax();
    }
    /**
     *this method delete the minimum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double delMin() {
        return minObj.delMin();
    }
    /**
     *gets the size of minheap.
     *
     * @return     The minimum size.
     */
    public int getMinSize() {
        return minObj.size();
    }
    /**
     * Gets the maximum size of maxheap.
     *
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return maxObj.size();
    }
}


/**
 * Solution class.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method is to.
     *take the input from user.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DynamicMedian obj = new DynamicMedian();
        long inputs = scan.nextLong();
        double element = scan.nextDouble();
        obj.insertAtMin(element);
        double median = element;
        System.out.println(median);
        for (long i = 1; i < inputs; i++) {
            double input = scan.nextDouble();
            if (input > median) {
                obj.insertAtMin(input);
            } else if (input < median) {
                obj.insertAtMax(input);
            } else {
                obj.insertAtMin(input);
            }
            if (obj.getMinSize() - obj.getMaxSize() > 1) {
                obj.insertAtMax(obj.delMin());
            }
            if (obj.getMaxSize() - obj.getMinSize()  > 1) {
                obj.insertAtMin(obj.delMax());
            }
            if (Math.abs(
                        obj.getMinSize() - obj.getMaxSize()) == 1) {
                if (obj.getMinSize() > obj.getMaxSize()) {
                    median = obj.getMin();
                    System.out.println(median);
                } else {
                    median = obj.getMax();
                    System.out.println(median);
                }
            }
            if (obj.getMinSize()  == obj.getMaxSize()) {
                double min = obj.getMin();
                double max = obj.getMax();
                median = (min + max) / 2.0;
                System.out.println(median);
            }
        }
    }
}
