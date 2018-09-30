
import java.util.Scanner;

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
        Node tmp = current;
        current = tmp.next;
        return tmp.data;
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

/**
 * Solution class.
 */
public final class Solution {


    private Solution() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for(int i = 0; i<n; i++) {
            CircularQueue counter = new CircularQueue();
            String[] tokens = input.nextLine().split(" ");
            int number = Integer.parseInt(tokens[0]);
            for(int j = 0; j<number; j++) {
                counter.insert(j);
                // System.out.println("j");
            }
            String str = "";
            while (!counter.isEmpty()) {
                int t2 = 0;
                for (int k = 0; k < Integer.parseInt(tokens[1]); k++) {
                    t2 = counter.getElement();
                }
                // System.out.print(cl.remove(t2) + " ");
                str += counter.remove(t2) + " ";
            }
            System.out.println(str.trim());
            // System.out.println();
            //*/
        }
    }

}





