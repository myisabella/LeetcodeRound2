package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
  public static int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    Deque<Integer> stack = new LinkedList<>();
    int i = 0;
    int max = 0;

    while (i < heights.length) {
      if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
        stack.push(i);
        i++;
      } else {
        int index = stack.pop();
        int height = heights[index];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, height * width);
      }
    }

    while (!stack.isEmpty()) {
      int index = stack.pop();
      int height = heights[index];
      int width = stack.isEmpty() ? i : i - stack.peek() - 1;
      max = Math.max(max, height * width);
    }

    return max;
  }
}
