package algorithm.tree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * Time Complexity: O(N) while N is the number of nodes in the smaller tree.
 * Note: it might fail when trees are too big.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Completed: 01/20/2016
 */

public class SameTree {
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == q) {
      return true;
    }

    if (p == null || q == null) {
      return false;
    }

    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
