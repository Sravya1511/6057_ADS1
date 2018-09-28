import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Deque deque = new Deque();
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for(int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split(" ");
            switch(tokens[0]) {
                case "pushLeft":
                deque.pushLeft(Integer.parseInt(tokens[1]));
                deque.print();
                break;
                case "pushRight":
                deque.pushRight(Integer.parseInt(tokens[1]));
                deque.print();
                break;
                case "popRight":
                if(deque.popRight()) {
                deque.print();
                }
                else {
                System.out.println("Deck is empty");
                }
                break;
                case "popLeft":
                if(deque.popLeft()) {
                deque.print();
                }
                else {
                System.out.println("Deck is empty");
                }
                break;
                case "size":
                System.out.println(deque.size());
                break;

            }
        }
    }

}