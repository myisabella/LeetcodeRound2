package algorithm.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * Time Complexity:
 *    Top-down: O(N^2)
 *    Bottom-up: O(N)
 *
 * Completed: 01/21/2016
 */
public class BalancedBinaryTree {
  public static boolean isBalancedTopDown(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(getDepthTopDown(root.left) - getDepthTopDown(root.right)) <= 1
        && isBalancedTopDown(root.left)
        && isBalancedTopDown(root.right)) {
      return true;
    }

    return false;
  }

  /**
   * Helper function to calculate the depth of a binary tree given its root recursively (top-down)
   * @param node    root of the binary tree
   * @return        depth of this binary tree as integer
   */
  private static int getDepthTopDown(TreeNode node) {
    if (node == null) {
      return 0;
    }

    return 1 + Math.max(getDepthTopDown(node.left), getDepthTopDown(node.right));
  }

  public static boolean isBalancedBottomUp(TreeNode root) {
    return getDepthBottomUp(root) != -1;
  }

  /**
   * Helper function to calculate the depth of a binary tree given its root recursively (button-up)
   * @param node    root of the binary tree
   * @return        depth of this binary tree, if it is not balanced, return -1
   */
  private static int getDepthBottomUp(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftDepth = getDepthBottomUp(node.left);
    if (leftDepth == -1) {
      return -1;
    }

    int rightDepth = getDepthBottomUp(node.right);
    if (rightDepth == -1) {
      return -1;
    }

    if (Math.abs(leftDepth - rightDepth) > 1) {
      return -1;
    }

    return 1 + Math.max(leftDepth, rightDepth);
  }
}
