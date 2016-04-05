package algorithm.stack;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 * Completed: 03/29/2016
 */
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    boolean isZig = true;
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelNum = queue.size();
      List<Integer> subList = new ArrayList<>();
      while (levelNum > 0) {
        TreeNode node = queue.poll();
        if (isZig) {
          subList.add(node.val);
        } else {
          subList.add(0, node.val);
        }

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        levelNum--;
      }
      result.add(subList);
      isZig = !isZig;
    }

    return result;
  }

  public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    levelMaker(result, root, 0);
    return result;
  }

  private void levelMaker(List<List<Integer>> list, TreeNode node, int levelNum) {
    if (node == null) return;
    if (levelNum >= list.size()) {
      list.add(new LinkedList<>());
    }

    List<Integer> collection = list.get(levelNum);
    if (levelNum % 2 == 0) {
      collection.add(node.val);
    } else {
      collection.add(0, node.val);
    }

    levelMaker(list, node.left, levelNum + 1);
    levelMaker(list, node.right, levelNum + 1);
  }

}
