import java.util.Scanner;
class HashTableChain<Key, Integer> {
	static final int capacity = 4;
	int n;
	int m;
	LinkedList<Key, Integer>[] st;

	HashTableChain() {
		this(capacity);
	}

	HashTableChain(int m) {
		this.m = m;
        st = (LinkedList<Key, Integer>[]) new LinkedList[m];
        for (int i = 0; i < m; i++)
            st[i] = new LinkedList<Key, Integer>();
	}

	private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return n;
    }

    // public boolean contains(Key key) {
    //     // if (key == null) throw new IllegalArgumentException("argument to contains() is null");
    //     return get(key) != null;
    // }

     public int get(Key key) {
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, int val) {


        // if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].insertAtStart(key, val);
    }

    public void compare(HashTableChain that) {
    	for(int i = 0; i<this.size(); i++) {
    		for(int j = 0; j<that.size(); j++) {
    			if(this.st[i].compareLinked(that.st[j]) == false) {
                    System.out.println("No");
                    return;
    		    }
    		    else {
    		    	System.out.println("Yes");
    		    	return;
    		    }
    		}
    	}
    	return;

    }
}

class LinkedList<String, Integer> {

	Node head;
	int size;

	class Node {
	String key;
	int value;
	Node next;

	Node(String k, int v) {
		this.key = k;
	    this.value = v;
	    this.next = null;
	}
    }

	public void insertAtStart(String key, int value) {
		Node first = new Node(key, value);
		if (head == null) {
			head = first;
			size++;
            return;
		}
		Node curr = head;
	    for(int i = 0; i<size; i++) {
            if(curr.key.equals(key)) {
            	curr.value +=1;
            	return;
            }
            curr = curr.next;
	    }
		first.next = head;
		head = first;
		size++;
	}

	public boolean compareLinked(LinkedList that) {
		Node nothead = this.head;

		Node maghead = that.head;
		for(int i = 0; i<this.size; i++) {
			if(nothead == null) {
				break;
            }
				int flag = 0;
				for(int j = 0; j<that.size; j++) {
					if(maghead == null) {
						break;
					}
					if(nothead.key.equals(maghead.key)) {
						flag = 1;
						if(nothead.value - maghead.value > 0) {
							return false;
						}

					}
					maghead = maghead.next;
				}
				if(flag == 0) {
					return false;
				}


            nothead = nothead.next;
			}
		return true;
	}

	public boolean contains(String key) {
		Node curr = head;
		for(int i = 0; i<size; i++) {
			if(curr.key.equals(key)) {
                return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public int get(String key) {
		Node curr = head;
		for(int i = 0; i<size; i++) {
			if(curr.key.equals(key)) {
                return curr.value;
			}
			curr = curr.next;
		}
		return -1;
	}
}

class Solutions {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] tokens = input.nextLine().split(" ");
		String[] magazine = input.nextLine().split(" ");
		String[] note = input.nextLine().split(" ");
		HashTableChain htmag = new HashTableChain();
		HashTableChain htnote = new HashTableChain();

		for(int i = 0; i<magazine.length; i++) {
			htmag.put(magazine[i], 1);
		}
		for(int i = 0; i<note.length; i++) {
			htnote.put(note[i], 1);
		}

		htnote.compare(htmag);

	}
}