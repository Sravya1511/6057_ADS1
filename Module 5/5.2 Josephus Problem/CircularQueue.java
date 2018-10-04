/**
 * class for circular queue.
 */
class CircularQueue {

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
        next = null;
       }
    }
    /**
     * inserts data into queue.
     *
     * @param      data  The data of integer type.
     */

    public void insert(int data) {
        Node n = new Node(data);
        if(size == 0) {
            front = n;
            rear = n;
        }
        else {
            rear.next = n;
            rear = rear.next;
        }
        size++;
    }
    /**
     * Gets the element.
     *
     * @return     The element of int type.
     */

    public int getElement() {
        if (current == null) {
            current = front;
        }
        Node n = current;
        current = n.next;
        return n.data;
    }

    /**
     * removes element from queue
     *
     * @param      element  The element of integer type
     *
     * @return     { returns removed element}
     */
    public int remove(int element) {

        if (front.data == element) {
            front = front.next;
            rear.next = front;
            size--;
            return element;
        }

        if (rear.data == element) {
            Node n = front;
            int count = 0;
            while(count < size-2) {
            n = n.next;
            count++;
            }
            n.next = front;
            rear = n;
            size--;
            return element;
        }

        if (size == 1) {
            int ele = front.data;
            front = null;
            size--;
            return ele;
        }

        Node n = front;
        while (n.next.data != element) {
            n = n.next;
        }
        n.next = n.next.next;;
        size--;
        return element;
    }
    /**
     * Determines if queue is empty or not.
     *
     * @return     True if empty, False otherwise.
     * returns boolean
     */

    public boolean isEmpty() {
        return size == 0;
    }

}
