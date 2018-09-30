import java.util.Scanner;
class CircularQueue {
    Node front;
    Node rear;
    int size = 0;

    class Node {
        int data;
        Node next;

    Node(int data1) {
        this.data = data1;
        next = null;
       }
    }

    public void print() {
        Node n = front;
        while(n!=null) {
            System.out.print(n.data+", ");
            n = n.next;
        }
        System.out.println();
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

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public int removeAt(int i) {
        if (i == 0) {
            Node n = front;
            int ele = front.data;
            front = front.next;
            size--;
            return ele;
        }
        if (i == size-1) {
            Node n = front;
            while (!n.next.equals(rear)) {
                n = n.next;
            }
            int element = n.next.data;
            n.next = front;
            rear = n;
            return element;
        }
        if(size == 1) {
            Node n = front;
            size--;
            return front.data;
        }
        Node n = front;
        int count = 0;
        while(count < i-1) {
            count++;
            n = n.next;
        }
        int ele = n.next.data;
        n.next = n.next.next;
        size--;
        return ele;
    }


}

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for(int i = 0; i<n; i++) {
            CircularQueue cq = new CircularQueue();
            String[] tokens = input.nextLine().split(" ");
            int number = Integer.parseInt(tokens[0]);
            for(int j = 0; j<number; j++) {
                cq.insert(j);
            }
            String str = "";
            while(!cq.isEmpty()) {
            int sum = 0;
            for(int k = 0; sum<cq.size()-1; k++) {
                sum = k+Integer.parseInt(tokens[1])-1;
                str += Integer.toString(cq.removeAt(sum))+" ";

            }

          }
        System.out.println(str);
        }

    }
}



