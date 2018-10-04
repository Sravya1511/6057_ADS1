import java.util.Scanner;
/**
 * Class for node.
 * Node class has two attributes.
 * Data of type int.
 * next of type Node
 */
class Node {
	int data;
	Node next;
	/**
	 * Constructs the object.
	 *
	 * @param      data  The data of type integer.
	 */

	Node(int data) {
	this.data = data;
	next = null;
	}

	 public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
}
/**
 * List of linkeds.
 */
class LinkedList {
	private Node head;
	int size = 0;
	int count = 0;

	public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void reverse() {
        reverse(head);
    }

    private void reverse(Node curr) {

        if (curr == null) {
            return;
        }

        if (curr.next == null) {
            head = curr;
            return;
        }

        reverse(curr.getNext());
        curr.next.next = curr;
        curr.next = null;
    }

	public void insertAt(int pos, int data) {
		size++;

		Node newNode = new Node(data);
		if (head == null) {
            head = newNode;
            return;
		}
		Node n = head;
		if(count == 0 && pos == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		if(pos == 0) {
			newNode.next = n.next;
			n.next = newNode;
			return;
		}
		else {
            n = n.next;
            count++;
            insertAt(pos-1, data);
		}
	}

	public int size() {
		return size;
	}



	public String print() {
    	Node n = head;
    	String result = "";
    	while(n!=null) {
    		result += n.data+", ";
    		n = n.next;
    	}
    	return result.substring(0, result.length()-2);
    }
}
class Solution {

    public static void main(String[] args) {
    	LinkedList list = new LinkedList();
    	Scanner input = new Scanner(System.in);
    	while(input.hasNext()) {
    		String[] token = input.nextLine().split(" ");
    		switch (token[0]) {
    			case "insertAt":
    			int size = list.size();
    			int position = Integer.parseInt(token[1]);
    			if(position <0 || position>size) {
    				System.out.println("Can't insert at this position.");
    			}
    			else {
                    list.insertAt(position, Integer.parseInt(token[2]));
    			    System.out.println(list.print());
    			}

    			break;
    			case "reverse":
    			if(list.size() == 0) {
    				System.out.println("No elements to reverse.");
    			}
    			else {
    				list.reverse();
    				System.out.println(list.print());
    			}

    			break;
    			default:
    			break;

    		}
    	}
    }
}
