import java.util.Scanner;
class LinkedList {
    Node head = null;
    // Node tail;
    int size = 0;

	class Node {
		int data;
		Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

	public void push(int data) {
		size++;
		Node n = new Node(data);
		if(head == null) {
			head = n;
		}
		else{
			n.next = head;
			head = n;
		}
	}

	public void enqueue(int data) {
		size++;
		Node last = new Node(data);
		if(head == null) {
			head = last;
			return;
		}
		Node n = head;
		while(n.next!=null) {
			n = n.next;
		}
		n.next = last;
	}

	public boolean pop() {
		if(size == 0) {
			return false;
		}
		else {
		    head = head.next;
		    size--;
		    return true;
		}
	}

	public void print() {
		if(size == 0) {
			System.out.println("Steque is empty.");
			return;
		}
		Node n = head;
		String str = "";
    	for(int i = 0; i<size-1; i++) {
            str = str+n.data+", ";
            n = n.next;
        }
        str+=n.data;
        System.out.println(str);
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		for(int i = 0; i<n; i++) {
			LinkedList list = new LinkedList();
			while(input.hasNext()) {
				String[] token = input.nextLine().split(" ");
				if(token[0].equals("")) {
					break;
				}
				switch(token[0]) {
					case "push":
					list.push(Integer.parseInt(token[1]));
					list.print();
					break;
					case "pop":
					if(list.pop()) {
					list.print();
					}
					else {
						System.out.println("Steque is empty.");
					}
					break;
					case "enqueue":
					list.enqueue(Integer.parseInt(token[1]));
					list.print();
					break;
				}
			}
			System.out.println();
		}

	}

}