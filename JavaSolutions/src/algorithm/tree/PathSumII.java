package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5, 4, 11, 2],
 *    [5, 8, 4, 5]
 * ]
 *
 * Completed: 2/9/16
 */
public class PathSumII {
  public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    DFS(root, sum, currentPath, result);
    return result;
  }

  private static void DFS(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> result) {
    if (node == null) return;
    currentPath.add(node.val);

    if (node.left == null && node.right == null && node.val == sum) {
      result.add(new ArrayList<>(currentPath));
      // back-tracking: remove last integer from current result
      currentPath.remove(currentPath.size() - 1);
      return;
    } else {
      DFS(node.left, sum - node.val, currentPath, result);
      DFS(node.right, sum - node.val, currentPath, result);
    }
    currentPath.remove(currentPath.size() - 1);
  }
}
