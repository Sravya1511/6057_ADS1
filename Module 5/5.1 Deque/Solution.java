import java.util.Scanner;
class Deque<E> {
	Node head;
	int size = 0;

    class Node {
    	E data;
    	Node next;

    Node(E data1) {
        this.data = data1;
        next = null;
       }
    }

    public void print() {
    	Node n = head;
        System.out.print("[");
    	for(int i = 0; i<size-1; i++) {
            System.out.print(n.data+", ");
            n = n.next;
        }
        System.out.println(n.data+"]");
    }

    public void pushLeft(E data) {
    	Node first = new Node(data);
        if (size == 0) {
        	head = first;
        	size++;
        	return;
        }
        first.next = head;
        head = first;
        size++;
    }

    public void pushRight(E data) {
    	if(size == 0) {
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


    public void popLeft() {
    	if (size == 0) {
    		System.out.println("No elements in array");
    		return;
    	}
        head = head.next;
        size--;
    }

    public void popRight() {
    	if (size == 0) {
    		System.out.println("No elements in array");
    		return;
    	}
        Node n = head;
        int count = 0;
        while(count < size-2) {
        	n = n.next;
        	count++;
        }
        // System.out.println(n.data);
        n.next = null;
        size--;
    }

    public int size() {
        return size;
    }
}
class Solution {
    public static void main(String[] args) {
        Deque deque = new Deque();
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for(int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split(" ");
            switch(tokens[0]) {
                case "pushLeft":
                deque.pushLeft(Integer.parseInt(tokens[1]));
                deque.print();
                break;
                case "pushRight":
                deque.pushRight(Integer.parseInt(tokens[1]));
                deque.print();
                break;
                case "popRight":
                deque.popRight();
                deque.print();
                break;
                case "popLeft":
                deque.popLeft();
                deque.print();
                break;
                case "size":
                System.out.println(deque.size());
                break;

            }
        }
    }

}