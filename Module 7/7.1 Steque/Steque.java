/**
 * class for Steque.
 * This class performs insertion and deletion operations.
 * The attributes are head and size.
 * head is Node type and size is integer type.
 * Push, pop, enqueue are the methods
 */
class Steque {
    Node head = null;
    int size = 0;

    /**
     * Class for node.
     * Node has two attributes.
     * 1. data of int type
     * 2. next of Node type.
     */

	class Node {
		int data;
		Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}
    /**
    * push method inserts elemnets into linked list from left side.
    * same as stack push.
     * The time complexity for push operation is 1.
    *
    * @param      data  The data
    */

	public void push(final int data) {
		size++;
		Node n = new Node(data);
		if (head == null) {
			head = n;
		} else {
			n.next = head;
			head = n;
		}
	}
	/**
	 * enqueue enters elements into linked lists from right side.
	 * same as queue enqueue.
	 * The time complexity for enqueue operation is n.
	 *
	 * @param      data  The data
	 */

	public void enqueue(final int data) {
		size++;
		Node last = new Node(data);
		if (head == null) {
			head = last;
			return;
		}
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = last;
	}
	/**
	 * pop method remves element from linkedlist.
	 * The element is removed from left side.
	 * same as pop operation of stack.
	 * The time complexity for pop operation is n.
	 *
	 * @return     { if size=0, returns false}.
	 */

	public boolean pop() {
		if (size == 0) {
			return false;
		} else {
		    head = head.next;
		    size--;
		    return true;
		}
	}
	/**
	 * printing the element in linkedlists.
	 * The time complexity for print operation is n.
	 */

	public void print() {
		if(size == 0) {
			System.out.println("Steque is empty.");
			return;
		}
		Node n = head;
		String str = "";
    	for (int i = 0; i < size - 1; i++) {
            str = str + n.data + ", ";
            n = n.next;
        }
        str += n.data;
        System.out.println(str);
	}
}
