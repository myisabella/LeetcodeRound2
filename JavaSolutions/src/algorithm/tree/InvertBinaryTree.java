package algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Invert a binary tree. For example, binary tree
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * will become to:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Completed: 2/9/16
 */
public class InvertBinaryTree {
  public static TreeNode invertTreeRecursive(TreeNode root) {
    if (root == null) {
      return null;
    }

    // Java method is "pass by value", so if just use root.left, root.right in the recursive call, it won't change
    final TreeNode left = root.left, right = root.right;
    root.left = invertTreeRecursive(right);
    root.right = invertTreeRecursive(left);

    return root;
  }

  public static TreeNode invertTreeIterative(TreeNode root) {
    if (root == null) {
      return null;
    }

    Deque<TreeNode> deque = new LinkedList<>();
    deque.add(root);

    while (!deque.isEmpty()) {
      final TreeNode node = deque.pop();
      final TreeNode left = node.left;
      node.left = node.right;
      node.right = left;

      if (node.left != null) {
        deque.push(node.left);
      }

      if (node.right != null) {
        deque.push(node.right);
      }
    }
    return root;
  }
}
