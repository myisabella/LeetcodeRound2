package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Post-order traversal:
 * 1. Traverse the left subtree.
 * 2. Traverse the right subtree.
 * 3. Display the data part of the root (or current node).
 */
public class BinaryTreePostOrderTraversal {
  public static List<Integer> postorderTraversalIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode prev = null;

    while (!stack.isEmpty()) {
      TreeNode current = stack.peek();

      // go down the tree to check if current node is leaf, if so, process it and pop stack,
      // otherwise, keep traversing
      if (prev == null || prev.left == current || prev.right == current) {
        // prev == null is for the root node case
        if (current.left != null) {
          stack.push(current.left);
        } else if (current.right != null) {
          stack.push(current.right);
        } else {
          stack.pop();
          list.add(current.val);
        }
      } else if (current.left == prev) {
        // go up the tree from left node, need to check if there is a right child
        // if so, push it to stack, otherwise, process parent node and pop stack
        if (current.right != null) {
          stack.push(current.right);
        } else {
          stack.pop();
          list.add(current.val);
        }
      } else if (current.right == prev) {
        // go up the tree from right node, after coming back from right node,
        // process parent node and pop stack
        stack.pop();
        list.add(current.val);
      }

      prev = current;
    }

    return list;
  }
}
