import java.util.Scanner;
/**
 * Class for add large numbers.
 * It performs three operations.
 */

class AddLargeNumbers {
    /**
     * number is added to linkedlist.
     * number is in string type.
     *
     * @param      number  The number
     *
     * @return     {returns list of type LinkedList }
     */

    public static LinkedList numberToDigits(final String number) {
        LinkedList list = new LinkedList();
        String[] tokens = number.split("");
        for (int i = 0; i < tokens.length; i++) {
            list.add(tokens[i]);
        }
        // list.print();
        return list;
    }
    /**
     * list is converted to string.
     *
     * @param      list  The list
     *
     * @return     { return type is string}
     */

    public static String digitsToNumber(final LinkedList list) {
        LinkedList lis = new LinkedList();
        String a = lis.print(list);
        return a;
    }

    /**
     * addition of two values in two linked lists.
     * result is stored in result Linkedlist
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { returns result of Linkedlist type }
     */

    public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {
        StackArray stack1 = new StackArray(list1.size);
        StackArray stack2 = new StackArray(list2.size);
        while (list1.isEmpty() == false) {
        stack1.push(list1.removeFirst());
        }
        while (list2.isEmpty() == false) {
        stack2.push(list2.removeFirst());
        }
        int maxSize = 0;
        if (stack2.size() > stack1.size()) {
            maxSize = stack2.size;
        } else {
            maxSize = stack1.size;
        }
        LinkedList result = new LinkedList();
        int sum = 0;
        int temp = 0;
        int carry = 0;
        while (maxSize > 0) {
            int a = stack1.pop();
            int b = stack2.pop();
            sum = a + b + carry;
            temp = sum % 10;
            carry = sum / 10;
            result.addNew(Integer.toString(temp));
            maxSize--;
        }
        if (carry != 0) {
        result.addNew(Integer.toString(carry));
        }
        return result;
    }
}
/**
 * Solution class.
 */

public class Solution {
    /**
     * reads input
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
