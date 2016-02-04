package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Completed: 02/03/2016
 */
public class SymmetricTree {
  private static boolean isSymmetricRecursive(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null) {
      return false;
    }

    return p.val == q.val && isSymmetricRecursive(p.left, q.right) && isSymmetricRecursive(p.right, q.left);
  }

  public static boolean isSymmetricRecursive(TreeNode root) {
    return root == null || isSymmetricRecursive(root.left, root.right);
  }

  public static boolean isSymmetricIterative(TreeNode root) {
    if (root == null) {
      return true;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root.left);
    queue.add(root.right);

    while (queue.size() > 1) {
      TreeNode left = queue.poll();
      TreeNode right = queue.poll();

      if (left == null && right == null) continue;
      if (left == null || right == null) {
        return false;
      }
      if (left.val != right.val) {
        return false;
      }

      queue.add(left.left);
      queue.add(right.right);
      queue.add(left.right);
      queue.add(right.left);
    }
    return true;
  }
}
