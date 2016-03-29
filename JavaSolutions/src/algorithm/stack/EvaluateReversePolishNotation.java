package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * Completed: 03/28/2016
 */
public class EvaluateReversePolishNotation {
  public static int evalRPN(String[] tokens) {
    // edge case: no input
    if (tokens.length == 0) {
      return 0;
    }

    Deque<Integer> stack = new LinkedList<>();
    int leftOperand, rightOperand;

    for (String s : tokens) {
      if (s.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if (s.equals("-")) {
        rightOperand = stack.pop();
        leftOperand = stack.pop();
        stack.push(leftOperand - rightOperand);
      } else if (s.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (s.equals("/")) {
        rightOperand = stack.pop();
        leftOperand = stack.pop();
        stack.push(leftOperand / rightOperand);
      } else {
        stack.push(Integer.parseInt(s));
      }
    }

    return stack.peek();
  }
}
