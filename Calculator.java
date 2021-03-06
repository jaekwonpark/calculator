import java.util.Stack;
// works for 1+2*3
public class Calculator {

	public static void main(String[] args) {
		int value = 0;
		System.out.printf("Input = %s\n", args[0]);
		value = calculate(args[0]); // assuming input has no error
		System.out.printf("Result = %s\n", Integer.toString(value));
	}

	private static int calculate(String in) {
		char[] tokens = in.toCharArray();
		Stack<String> stack = new Stack<String>();
		stack.push(tokens[0]+""); // add the first number
		for (int i = 1; i < tokens.length; i++) {
			stack.push(tokens[i]+"");// push operator
			if (tokens[i] == '+' || tokens[i] == '-') {
				stack.push(tokens[++i]+""); // push operand
			} else {
				String op = stack.pop();
				int operand1 = Integer.valueOf(stack.pop());
				i++;
				int operand2 = Integer.valueOf(tokens[i]+"");

				String result = Integer.toString(evaluate(op, operand1, operand2));
				stack.push (result);
			}
		}


		int operand1 = Integer.valueOf(stack.pop());
		int leftOver = stack.size();
		for (int i = 0; i < leftOver; i += 2) {
			String op = stack.pop();
			int operand2 = Integer.valueOf(stack.pop());
			operand1 = evaluate(op, operand1, operand2);
		}

		return operand1;
	}

	private static int evaluate(String op, int op1, int op2) {
		char chOp = op.charAt(0);
		int result = 0;
		switch (chOp) {
			case '+': result = op1 + op2;
				break;
			case '-': result = op1 - op2;
				break;
			case '*': result = op1 * op2;
				break;
			case '/': result = op1 / op2;
				break;
			case '%': result = op1 % op2;
		} // assume there is no unexpected operator

		return result;
	}

}
