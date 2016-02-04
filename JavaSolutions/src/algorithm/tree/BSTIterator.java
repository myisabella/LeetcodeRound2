package algorithm.tree;

import java.util.Stack;


/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * Completed: 01/27/2016
 */
public class BSTIterator {
  private Stack<TreeNode> stack = null;
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();

    TreeNode p = root;
    while (p != null) {
      stack.push(p);
      p = p.left;
    }
  }

  /**
   * @return    whether we have a next smallest number
   */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /**
   * @return    the next smallest number
   */
  public int next() {
    if (hasNext()) {
      int min = stack.peek().val;
      TreeNode p = stack.pop();

      if (p.right != null) {
        p = p.right;

        while (p != null) {
          stack.push(p);
          p = p.left;
        }
      }

      return min;
    }

    return -1;
  }
}
