import java.util.Scanner;
/**
 * Class for solution.
 * reads input.
 */
final class Solution {
    /**
     * Constructs the object.
     */

    private Solution() {

    }
    /**
     * the object for linkedlist class is created.
     * The insertAt method and reverse methods are called.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        LinkedList list = new LinkedList();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String[] token = input.nextLine().split(" ");
            switch (token[0]) {
                case "insertAt":
                int size = list.size();
                int position = Integer.parseInt(token[1]);
                if (position < 0 || position > size) {
                System.out.println("Can't insert at this position.");
                } else {
                list.insertAt(position, Integer.parseInt(token[2]));
                System.out.println(list.print());
                }
                break;
                case "reverse":
                if (list.size() == 0) {
                    System.out.println("No elements to reverse.");
                } else {
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
/**
 * Class for node.
 * Node class has two attributes.
 * Data of type int.
 * next of type Node.
 */
class Node {
    /**
     * data is integer type.
     * next is Node.
     */
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


}
/**
 * List of linked lists.
 * This class has two methods
 * InsertAt and Reverse.
 */
class LinkedList {
    private Node head;
    int size = 0;
    int count = 0;
/**
 * overloaded method for reverse.
 * this method is called in main function
 */
    public void reverse() {
        reverse(head);
    }
    /**
     * reverse method to reverse linked list.
     *
     * @param      curr  The curr of Node type.
     */

    private void reverse(final Node curr) {

        if (curr == null) {
            return;
        }
        if (curr.next == null) {
            head = curr;
            return;
        }
        reverse(curr.next);
        curr.next.next = curr;
        curr.next = null;
    }
    /**
     * overloaded method to insert the element.
     *
     * @param      index  The index of type integer
     * @param      data   The data of type integer
     */

    public void insertAt(final int index, final int data) {


        head = insertAt(head, new Node(data), index, 0);
        size++;

    }
    /**
     * inserts elements using recurssion.
     *
     * @param      curr       The curr of Node type.
     * @param      newNode    The new node of Node type.
     * @param      index      The index of integer type.
     * @param      currIndex  The curr index of integer type.
     *
     * @return     { returns Node type }
     */

    private Node insertAt(final Node curr, final Node newNode, final int index, final int currIndex) {
        if (curr == null) {
            return newNode;
        } else if (currIndex == index) {
            newNode.next = curr;
            return newNode;
        }
        curr.next = insertAt(curr.next, newNode, index, currIndex+1);
        return curr;

    }


    /**
     * size of the linked list is returned.
     *
     * @return     { return tye is integer. }
     */

    public int size() {
        return size;
    }
    /**
     * prints the linkedlist data.
     *
     * @return     { String is returned. }
     */

    public String print() {
        Node n = head;
        String result = "";
        while (n != null) {
            result += n.data + ", ";
            n = n.next;
        }
        return result.substring(0, result.length() - 2);
    }

    // public void insertAt(int pos, int data) {
    //  size++;

    //  Node newNode = new Node(data);
    //  if (head == null) {
 //            head = newNode;
 //            return;
    //  }
    //  Node n = head;
    //  if(count == 0 && pos == 0) {
    //      newNode.next = head;
    //      head = newNode;
    //      return;
    //  }
    //  if(pos == 0) {
    //      newNode.next = n.next;
    //      n.next = newNode;
    //      return;
    //  }
    //  else {
 //            n = n.next;
 //            count++;
 //            insertAt(pos-1, data);
    //  }
    // }
}
