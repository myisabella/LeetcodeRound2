package algorithm.tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
  public static boolean isValidBST(TreeNode root) {
    // using Integer.MIN_VALUE/Integer.MAX_VALUE will cause issues
    return validateBST(root, null, null);
  }

  private static boolean validateBST(TreeNode node, Integer min, Integer max) {
    if (node == null) {
      return true;
    }

    if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
      return false;
    }

    // change min/max values as moving down the BST
    return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
  }
}
