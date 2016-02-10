package algorithm.tree;

import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given sum.
 *
 * Completed: 02/03/2016
 */
public class PathSum {
  public static boolean hasPathSumRecursive(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null && root.val == sum) {
      return true;
    }

    return hasPathSumRecursive(root.left, sum - root.val) || hasPathSumRecursive(root.right, sum - root.val);
  }

  public static boolean hasPathSumIterative(TreeNode root, int sum) {
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> sums = new Stack<>();

    stack.push(root);
    sums.push(sum);

    while (!stack.isEmpty() && root != null) {
      int val = sums.pop();
      TreeNode top = stack.pop();

      // Stop condition
      if (top.left == null && top.right == null && top.val == val) {
        return true;
      }

      if (top.right != null) {
        stack.push(top.right);
        sums.push(val - top.val);
      }

      if (top.left != null) {
        stack.push(top.left);
        sums.push(val - top.val);
      }
    }

    return false;
  }
}
