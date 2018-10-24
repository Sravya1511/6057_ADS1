import java.util.Scanner;
class BinaryTreeClass {
	Node root = null;

	BinaryTreeClass() {
	}

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void mirror() {
		root = mirror(root);
	}

	public Node mirror(Node x) {
		if(x == null) {
			return x;
		}
		Node left = mirror(x.left);
		Node right = mirror(x.right);
		x.left = right;
		x.right = left;
		return x;
	}

	public void insert(int a) {

        root = insert(root, a);
    }
    private Node insert(Node x, int a) {

        if (x == null) {
            return new Node(a);
        }

        if (a < x.data) {
            x.left  = insert(x.left, a);
        } else if (a > x.data) {
            x.right = insert(x.right, a);
        }
        return x;
    }

	 public void inorder()
     {
         inorder(root);
     }
     private void inorder(Node r)
     {
     	if(r == null) {
     		return;
     	}
             inorder(r.left);
             System.out.print(r.data +" ");
             inorder(r.right);

     }
}

class Mirror {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = Integer.parseInt(input.nextLine());
		BinaryTreeClass bs = new BinaryTreeClass();
	    for(int i = 0; i<number; i++) {
			int a = Integer.parseInt(input.nextLine());
			// Node n = new Node(a);
			bs.insert(a);
		}
        System.out.println("Inorder");
		bs.inorder();

		bs.mirror();
		System.out.println("Inorder of mirror");
		bs.inorder();
	}
}