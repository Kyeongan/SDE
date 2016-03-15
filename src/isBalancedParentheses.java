import java.util.Scanner;
import java.util.Stack;

public class isBalancedParentheses {

	// {}()
	// ({()})
	// {}(
	// []
	//
	// true
	// true
	// false
	// true

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String str = sc.next();

			if (CheckParentesis(str))
				System.out.println("True");
			else
				System.out.println("False");
		}
	}

	public static boolean CheckParentesis(String str) {
		if (str.isEmpty())
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == '{' || current == '(' || current == '[') {
				stack.push(current);
			}

			if (current == '}' || current == ')' || current == ']') {
				if (stack.isEmpty())
					return false;

				char last = stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
					stack.pop();
				else
					return false;
			}

		}

		return stack.isEmpty();
	}

}
