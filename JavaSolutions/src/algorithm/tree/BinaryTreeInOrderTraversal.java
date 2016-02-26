package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * In-order traversal:
 * 1. Traverse the left subtree.
 * 2. Display the data part of the root (or current node).
 * 3. Traverse the right subtree.
 */
public class BinaryTreeInOrderTraversal {
  public static List<Integer> inorderTraversalRecursively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root != null) {
      list.addAll(inorderTraversalRecursively(root.left));
      list.add(root.val);
      list.addAll(inorderTraversalRecursively(root.right));
    }

    return list;
  }

  public static List<Integer> inorderTraversalIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;

    while (!stack.isEmpty() || p != null) {
      if (p != null) {
        stack.push(p);
        p = p.left;
      } else {
        TreeNode t = stack.pop();
        list.add(t.val);
        p = t.right;
      }
    }

    return list;
  }
}
