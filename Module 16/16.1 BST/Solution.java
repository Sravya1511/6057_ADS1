import java.util.Scanner;
class BookKey {
	String name;
	String author;
	float price;

	BookKey(String n, String a, float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}

	public String getName() {
		return this.name;
	}


}
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	int size;
	BinarySearchTree() {

	}

	Node root;

	class Node {
		BookKey key;
		int value;
		Node left;
		Node right;

		Node(BookKey key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	 public void put(BookKey key, int val) {
        if (key == null) {
        	return;
        }

        root = put(root, key, val);

    }

    private Node put(Node x, BookKey key, int val) {
    	size++;
        if (x == null) return new Node(key, val);
        int cmp = key.name.compareTo(x.key.name);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.value   = val;
        // x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Integer get(BookKey key) {
        return get(root, key);
    }

    private Integer get(Node x, BookKey key) {
        if(x == null) {
        	// System.out.println("null");
        	return null;
        }
        int cmp = key.getName().compareTo(x.key.getName());
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.value;
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BinarySearchTree binarySearch = new BinarySearchTree();
		while(input.hasNext()) {
			String[] tokens = input.nextLine().split(",");
            switch(tokens[0]) {
            	case "put":
            	BookKey key = new BookKey(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
            	int value = Integer.parseInt(tokens[4]);
            	binarySearch.put(key, value);
            	break;
            	case "get":
            	BookKey key1 = new BookKey(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
            	System.out.println(binarySearch.get(key1));

            	break;

            }

		}
	}
}