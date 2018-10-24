/**
 * class for circular queue.
 */
class Queue {

    Node head = null;
    Node tail = null;
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
    }
    /**
     * inserts data into queue.
     *
     * @param      element  The data of integer type.
     */
     public void enqueue(final int element) {
        if (head == null) {
            head = new Node();
            tail = new Node();
            head.data = element;
            tail = head;
            return;
        }
        current = new Node();
        current.data = element;
        tail.next = current;
        tail = current;
    }
    /**
     * removes element form queue
     *
     * @return     { returns the elemnet that wa removed }
     */

    public int dequeue() {
        Node temp = new Node();
        if (head == tail) {
            temp = head;
            head = null;
            tail = null;
            return temp.data;
         }
         temp = head;
         head = head.next;
         return temp.data;
    }

     /**
     * checks whether queue is empty or Not.
     * @return true are flase.
     */
    public boolean isEmpty() {
        return head == null;
    }
}
