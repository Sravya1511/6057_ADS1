import java.util.Stack;
import java.util.Scanner;
import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int lines = Integer.parseInt(scn.nextLine());
		for(int i = 0; i<lines; i++) {
			String[] tokens = scn.nextLine().split("");
			paranthesis(tokens);
		}
	}

	public static void paranthesis(String[] tokens) {
		boolean x = false;
		Stack<String> str = new Stack<>();
		for(int j = 0; j<tokens.length; j++) {
		    if(tokens[j].equals("}") || tokens[j].equals("]") || tokens[j].equals(")")) {
		        if(str.isEmpty()) {
		        	System.out.println("NO");
		        	x = true;
		        	break;

		        	}
				str.pop();
			    }
			    else{
			        str.push(tokens[j]);
			    }
			}
            // System.out.println(str);
            if(!x) {
            	if(str.isEmpty()) {
            	System.out.println("YES");
            }
            else {
            	System.out.println("NO");
            }
            }

		}

	}