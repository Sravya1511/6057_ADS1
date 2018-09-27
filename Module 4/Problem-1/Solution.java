import java.util.Stack;


class Solution {
	public static void main(String[] args) {
		Stack<String> str = new Stack<>();
		String input = "it was - the best - of times - - - it was - the - -";
		String [] tokens = input.split(" ");
		for(int i = 0; i<tokens.length; i++) {
			if(tokens[i].equals("-")) {
				str.pop();
			}
			else{
			    str.push(tokens[i]);
			}

		}
		System.out.println(str);
	}
}