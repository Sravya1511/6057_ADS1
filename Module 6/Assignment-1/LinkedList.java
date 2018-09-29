class LinkedList {
    Node head;
    int size = 0;

    static class Node {
        String data;
        Node next;

    Node(String data1) {
        this.data = data1;
        next = null;
       }
    }

    public void addNew(String data) {
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

    public void add(String data) {
        if(size == 0) {
            addNew(data);
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

    public int removeFirst() {
        if (size == 0) {
            return 0;
        }
        String n = head.data;
        head = head.next;
        size--;
        return Integer.parseInt(n);
    }

    public String print(LinkedList list) {
        String s = "";
        Node n = list.head;
        while(n!=null) {
            s += n.data;
            n = n.next;
        }
        return s;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
}
