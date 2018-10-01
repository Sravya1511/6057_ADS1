class LinkedList {
	Node head = null;
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
		if(size == 0) {
            head = n;
		}
		else{
			n.next = head;
			head = n;
		}
	}

	public int pop() {
		Node n = head;
		head = head.next;
		size--;
		return n.data;
	}
}
