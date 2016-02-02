package algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example: given binary tree {3, 9, 20, #, #, 15, 7} returns its level order traversal as:
 * [
 *    [3],
 *    [9,20],
 *    [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
  public static List<List<Integer>> levelOrderBFS(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    if (root == null) {
      return result;
    }

    queue.add(root);

    while(!queue.isEmpty()) {
      int levelNum = queue.size();
      List<Integer> subList = new LinkedList<>();
      while (levelNum > 0) {
        if (queue.peek().left != null) {
          queue.add(queue.peek().left);
        }
        if (queue.peek().right != null) {
          queue.add(queue.peek().right);
        }
        subList.add(queue.remove().val);
        levelNum--;
      }
      result.add(subList);
    }
    return result;
  }

  public static List<List<Integer>> levelOrderDFS(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    levelMaker(result, root, 0);
    return result;
  }

  private static void levelMaker(List<List<Integer>> list, TreeNode node, int levelNum) {
    if (node == null) return;
    if (levelNum >= list.size()) {
      list.add(new LinkedList<>());
    }
    list.get(levelNum).add(node.val);
    levelMaker(list, node.left, levelNum + 1);
    levelMaker(list, node.right, levelNum + 1);
  }
}
