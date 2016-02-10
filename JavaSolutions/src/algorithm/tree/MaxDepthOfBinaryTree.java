package algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;


/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Completed: 02/05/2016
 */
public class MaxDepthOfBinaryTree {
  public static int maxDepthRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
  }

  public static int maxDepthIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Deque<TreeNode> deque = new LinkedList<>();
    int count = 0;

    deque.push(root);

    while (!deque.isEmpty()) {
      int size = deque.size();
      while (size > 0) {
        TreeNode node = deque.pop();
        if (node.left != null) {
          deque.addLast(node.left);
        }
        if (node.right != null) {
          deque.addLast(node.right);
        }
        size--;
      }
      count++;
    }
    return count;
  }
}
