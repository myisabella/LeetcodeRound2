package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * Completed: 04/04/2016
 */
public class TrappingRainWater {
  public static int trapWithStack(int[] height) {
    int water = 0;
    Deque<Integer> stack = new LinkedList<>();

    for (int i = 0; i < height.length; i++) {
      if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
        stack.push(i);
      } else {
        int temp = stack.pop();
        if (!stack.isEmpty()) {
          int length = i - stack.peek() - 1;
          int delta = Math.min(height[stack.peek()], height[i]) - height[temp];
          water += delta * length;
        }
        i--;
      }
    }
    return water;
  }

  public static int trapWithTwoPointers(int[] height) {
    int leftIndex = 0, rightIndex = height.length - 1;
    int water = 0;
    int leftMax = 0, rightMax = 0;

    while (leftIndex <= rightIndex) {
      leftMax = Math.max(leftMax, height[leftIndex]);
      rightMax = Math.max(rightMax, height[rightIndex]);
      if (leftMax < rightMax) {
        water += (leftMax - height[leftIndex]);
        leftIndex++;
      } else {
        water += (rightMax - height[rightIndex]);
        rightIndex--;
      }
    }

    return water;
  }
}
