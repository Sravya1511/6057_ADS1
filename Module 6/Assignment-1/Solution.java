import java.util.Scanner;
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

class StackArray {
    int[] array;
    int size;

    StackArray(int n) {
        array = new int[n];
        size = 0;
    }

    public void push(int item) {
        array[size++] = item;
    }

    public int pop() {
        int a = array[size-1];
        size--;
        return a;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public int peek() {
        int a = size-1;
        return array[a];
    }
}

class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        String[] tokens = number.split("");
        for(int i = 0; i<tokens.length; i++) {
            list.add(tokens[i]);
        }
        // list.print();
        return list;

    }

    public static String digitsToNumber(LinkedList list) {
        LinkedList lis = new LinkedList();
        String a = lis.print(list);
        return a;

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        StackArray stack1 = new StackArray(list1.size);
        StackArray stack2 = new StackArray(list2.size);
        while(list1.isEmpty() == false) {
        stack1.push(list1.removeFirst());
        }
        while(list2.isEmpty() == false) {
        stack2.push(list2.removeFirst());
        }
        LinkedList result = new LinkedList();
        int sum = 0;
        int temp = 0;
        int carry = 0;
        while(stack2.isEmpty() == false) {
            int a = stack1.pop();
            int b = stack2.pop();
            sum = a+b+carry;
            temp = sum%10;
            carry = sum/10;
            result.addNew(Integer.toString(temp));
            // int sum = carry + a + b;
            // result.data = sum % 10;
            // carry = sum / 10;
            // r = a+b;
            // System.out.println(r);
        }
        result.addNew(Integer.toString(carry));
        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                // AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                break;
        }
    }
}
