import java.util.Scanner;
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

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList stack = new LinkedList();
		String[] n = input.nextLine().split(" ");
		for(int i = 0; i<n.length; i++) {
			switch (n[i]) {
				case "+":
				int res = stack.pop() + stack.pop();
				stack.push(res);
				break;
				case"-":
				int res1 = stack.pop() - stack.pop();
				stack.push(res1);
				break;
				case "*":
				int res2 = stack.pop() * stack.pop();
				stack.push(res2);
				break;
				case "/":
				int res3 = stack.pop() / stack.pop();
				stack.push(res3);
				break;
				default:
				stack.push(Integer.parseInt(n[i]));
				break;

			}
		}
        System.out.println(stack.pop());
	}
}