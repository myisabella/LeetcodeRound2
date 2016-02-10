package algorithm.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as
 * the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 * Since the given tree is a BST, we should use the property of BST: the value of its value should be bigger than its
 * left child's value, smaller than its right child's value.
 *
 * Completed: 02/04/2016
 */
public class LCAofBST {
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    } else {
      return root;
    }
  }
}
