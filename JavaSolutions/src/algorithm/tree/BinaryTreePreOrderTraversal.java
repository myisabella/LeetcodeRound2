package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Pre-order traversal:
 * 1. Display the data part of the root (or current node).
 * 2. Traverse the left subtree.
 * 3. Traverse the right subtree.
 */
public class BinaryTreePreOrderTraversal {
  public static List<Integer> preorderTraversalRecursively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root != null) {
      list.add(root.val);
      list.addAll(preorderTraversalRecursively(root.left));
      list.addAll(preorderTraversalRecursively(root.right));
    }

    return list;
  }

  public static List<Integer> preorderTraversalIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode p = stack.pop();
      list.add(p.val);

      // Push right tree first so that when adding to list, right part goes after the left
      if (p.right != null) {
        stack.push(p.right);
      }

      if (p.left != null) {
        stack.push(p.left);
      }
    }

    return list;
  }
}
