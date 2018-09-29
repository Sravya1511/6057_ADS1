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

    public String print(LinkedList list) {
        String s = "";
        Node n = list.head;
        while(n!=null) {
            s += n.data;
            n = n.next;
        }
        return s;
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

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

    // }
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

            // case "addLargeNumbers":
            //     LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            //     LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }

}
