package algorithm.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * Time Complexity:
 *
 * Completed: 01/21/2016
 */
public class BalancedBinaryTree {
  public static boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1
        && isBalanced(root.left)
        && isBalanced(root.right)) {
      return true;
    }

    return false;
  }

  /**
   * Helper function to calculate the depth of a binary tree given its root recursively
   * @param node    root of the binary tree
   * @return        depth of this binary tree as integer
   */
  private static int getDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    return 1 + Math.max(getDepth(node.left), getDepth(node.right));
  }
}
