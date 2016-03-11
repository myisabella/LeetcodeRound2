package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Completed: 03/10/2016
 */
public class MinStack {
  private Deque<Integer> stack;
  private Deque<Integer> minValues;

  public MinStack() {
    stack = new LinkedList<>();
    minValues = new LinkedList<>();
  }

  public void push(int x) {
    stack.push(x);
    if (minValues.isEmpty() || x <= minValues.peek()) {
      minValues.push(x);
    }
  }

  public void pop() {
    int x = stack.pop();
    if (x == minValues.peek()) {
      minValues.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minValues.peek();
  }
}
