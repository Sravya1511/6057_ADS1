// import java.util.Stack;
// import java.util.Scanner;
// import java.util.Arrays;

// class Test {
// 	public static void main(String[] args) {
// 		Scanner scn = new Scanner(System.in);
// 		int lines = Integer.parseInt(scn.nextLine());
// 		for(int i = 0; i<lines; i++) {
// 			String[] tokens = scn.nextLine().split("");
// 			paranthesis(tokens);
// 		}
// 	}

// 	public static void paranthesis(String[] tokens) {
// 		boolean x = false;
// 		Stack<String> str = new Stack<>();
// 		for(int j = 0; j<tokens.length; j++) {
// 		    if(tokens[j].equals("}") || tokens[j].equals("]") || tokens[j].equals(")")) {

// 		        if(str.isEmpty()) {
// 		        	System.out.println("NO");
// 		        	x = true;
// 		        	break;

// 		        	}
// 				str.pop();
// 			    }
// 			    else{
// 			        str.push(tokens[j]);
// 			    }
// 			}
//             // System.out.println(str);
//             if(!x) {
//             	if(str.isEmpty()) {
//             	System.out.println("YES");
//             }
//             else {
//             	System.out.println("NO");
//             }
//             }
// 		}
// 	}


// import java.util.Stack;
// import java.util.Scanner;
// import java.util.Arrays;

// class StackArray {
// 	String[] array;
// 	int size;

// 	StackArray(int n) {
// 		array = new String[n];
// 		size = 0;
// 	}

// 	public void push(String item) {
// 		array[size++] = item;
// 	}

// 	public void pop() {
// 		array[size-1] = null;
// 		size--;
// 	}
// 	public boolean isEmpty() {
// 		if (size == 0) {
// 			return true;
// 		}
// 		else {
// 			return false;
// 		}
// 	}
// 	public String peek() {
// 		int a = size-1;
// 		return array[a];
// 	}
// }

// class Solution {
// 	public static void main(String[] args) {
// 		Scanner scn = new Scanner(System.in);
// 		int lines = Integer.parseInt(scn.nextLine());
// 		for(int i = 0; i<lines; i++) {
// 			String[] tokens = scn.nextLine().split("");
// 			paranthesis(tokens);
// 		}
// 	}

// 	public static void paranthesis(String[] tokens) {
// 		boolean x = false;
// 		String i = ")";
// 		String j = "]";
// 		String k = "}";
// 		StackArray str = new StackArray(tokens.length);
// 		for(int m = 0; m<tokens.length; m++) {
// 		    if(tokens[m].equals(i) || tokens[m].equals(j) || tokens[m].equals(k)) {
// 		        if(str.isEmpty()) {
// 		        	System.out.println("NO");
// 		        	x = true;
// 		        	break;
// 		        }
// 		        String a = str.peek();
// 		        // System.out.println(a);
// 		        if(a.equals("(") && (tokens[m].equals("]") || tokens[m].equals("}"))) {
// 		        	System.out.println("NO");
// 		        	x = true;
// 		        	break;
// 		        }
// 		        if(a.equals("{") && (tokens[m].equals("]") || tokens[m].equals(")"))) {
// 		        	System.out.println("NO");
// 		        	x = true;
// 		        	break;
// 		        }
// 		        if(a.equals("[") && (tokens[m].equals(")") || tokens[m].equals("}"))) {
// 		        	System.out.println("NO");
// 		        	x = true;
// 		        	break;
// 		        }
// 		        str.pop();
// 			}
// 			    else{
// 			        str.push(tokens[m]);
// 			    }
// 			}
//             // System.out.println(str);
//             if(!x) {
//             	if(str.isEmpty()) {
//             	System.out.println("YES");
//             }
//             else {
//             	System.out.println("NO");
//             }
//             }

// 		}

// 	}