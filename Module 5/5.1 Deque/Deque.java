/**
 * Class for deque.
 *
 * @param      <E>   { Generic (integer type) }
 */
class Deque<E> {
	Node head;
	int size = 0;

    /**
     * Class for node.
     */

    class Node {
    	E data;
    	Node next;
    /**
     * Constructs the object.
     *
     * @param      data1  The data1 of E type.
     */
    Node(E data1) {
        this.data = data1;
        next = null;
       }
    }

    /**
     * Determines if the queue is empty or not.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }
    /**
     * prints the values of queue.
     */

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
    	Node n = head;
        System.out.print("[");
    	for(int i = 0; i<size-1; i++) {
            System.out.print(n.data+", ");
            n = n.next;
        }
        System.out.println(n.data+"]");
    }

    /**
     * The data is added from left side.
     *
     * @param      data  The data of E type.
     */

    public void pushLeft(E data) {
    	Node first = new Node(data);
        if (isEmpty()) {
        	head = first;
        	size++;
        	return;
        }
        first.next = head;
        head = first;
        size++;
    }

    /**
     * The data is added from right.
     *
     * @param      data  The data of E type.
     */

    public void pushRight(E data) {
    	if(isEmpty()) {
    		pushLeft(data);
    		return;
    	}
    	Node last = new Node(data);
    	Node n = head;
    	int count = 0;
    	while(count < size-1) {  /**because of head**/
    		n = n.next;
    		count++;
    	}
    	n.next = last;
    	last.next = null;
    	size++;
    }

    /**
     * removes elements form left.
     *
     * @return     { returns false if queuue is empty
     * else removes element}
     */


    public boolean popLeft() {
    	if (isEmpty()) {
    		return false;
    	}
        head = head.next;
        size--;
        return true;
    }

    /**
     * returns false if the queue is empty. else removes element from right.
     *
     * @return     { returns true or false }
     */

    public boolean popRight() {
    	if (isEmpty()) {
    		return false;
    	}
        Node n = head;
        int count = 0;
        while(count < size-2) {
        	n = n.next;
        	count++;
        }
        n.next = null;
        size--;
        return true;
    }
    /**
     * size of the queue
     *
     * @return     { integer type }
     */

    public int size() {
        return size;
    }
}