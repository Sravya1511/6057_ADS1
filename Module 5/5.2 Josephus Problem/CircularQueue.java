class CircularQueue {


    Node front = null;
    Node rear = null;
    Node current = null;
    int size;

    class Node {
        int data;
        Node next;

    Node(int data1) {
        this.data = data1;
        next = null;
       }
    }


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

    public int getElement() {
        if (current == null) {
            current = front;
        }
        Node n = current;
        current = n.next;
        return n.data;
    }

    ///*
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

    public boolean isEmpty() {
        return size == 0;
    }

}
