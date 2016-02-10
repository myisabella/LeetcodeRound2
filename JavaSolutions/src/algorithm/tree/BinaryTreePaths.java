package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are: ["1->2->5", "1->3"]
 *
 * Completed: 2/9/16
 */
public class BinaryTreePaths {
  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root != null) {
      DFS(root, "", result);
    }
    return result;
  }

  private static void DFS(TreeNode node, String path, List<String> result) {
    if (node.left == null && node.right == null) {
      result.add(path + node.val);
    }

    if (node.left != null) {
      DFS(node.left, path + node.val + "->", result);
    }

    if (node.right != null) {
      DFS(node.right, path + node.val + "->", result);
    }
  }
}
