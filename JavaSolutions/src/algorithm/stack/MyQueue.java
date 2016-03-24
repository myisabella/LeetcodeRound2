package algorithm.stack;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *  push(x) -- Push element x to the back of queue.
 *  pop() -- Removes the element from in front of queue.
 *  peek() -- Get the front element.
 *  empty() -- Return whether the queue is empty.
 *
 * Completed: 03/14/2016
 */
public class MyQueue {
  private Stack<Integer> input;
  private Stack<Integer> output;

  public MyQueue() {
    input = new Stack<>();
    output = new Stack<>();
  }

  // Push element x to the back of queue.
  public void push(int x) {
    input.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    peek();
    output.pop();
  }

  // Get the front element.
  public int peek() {
    if (output.isEmpty()) {
      while (!input.isEmpty()) {
        output.push(input.pop());
      }
    }
    return output.peek();
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return input.isEmpty() && output.isEmpty();
  }
}
