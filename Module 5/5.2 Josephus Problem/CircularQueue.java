/**
 * class for circular queue.
 */
class Queue {

    Node front = null;
    Node rear = null;
    Node current = null;
    int size;

    /**
     * Class for node.
     * Node has data
     * and next
     */
    class Node {
        int data;
        Node next;

    /**
     * constructor for node class
     *
     * @param      data1  The data1 of integer type.
     */
    Node(int data1) {
    	this.data = data1;
    	this.next = null;
    }

    Node() {

    }
    }
    /**
     * inserts data into queue.
     *
     * @param      element  The data of integer type.
     */
     public void enqueue(final int element) {
        if (front == null) {
            front = new Node(element);
            rear = new Node(element);
            rear = front;
            return;
        }
        current = new Node(element);
        // current.data = element;
        rear.next = current;
        rear = current;
    }
    /**
     * removes element form queue
     *
     * @return     { returns the elemnet that wa removed }
     */

    public int dequeue() {
        Node temp = new Node();
        if (front == rear) {
            temp = front;
            front = null;
            rear = null;
            return temp.data;
         }
         temp = front;
         front = front.next;
         return temp.data;
    }

     /**
     * checks whether queue is empty or Not.
     * @return true are flase.
     */
    public boolean isEmpty() {
        return front == null;
    }
}
