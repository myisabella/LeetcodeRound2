package algorithm.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design an algorithm to serialize and deserialize a binary tree.
 *
 * For example, you may serialize the following tree
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * as "[1,2,3,null,null,4,5].
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithm
 * should be stateless.
 *
 * Completed: 02/27/2016
 */
public class Codec {
  private static final String DIVIDER = ",";
  private static final String NULLNODE = "#";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }

  private void buildString(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append(NULLNODE).append(DIVIDER);
    } else {
      sb.append(node.val).append(DIVIDER);
      buildString(node.left, sb);
      buildString(node.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(DIVIDER)));
    return buildBinaryTree(nodes);
  }

  private TreeNode buildBinaryTree(Queue<String> nodes) {
    String val = nodes.remove();
    if (val.equals(NULLNODE)) {
      return null;
    } else {
      TreeNode node = new TreeNode(Integer.valueOf(val));
      node.left = buildBinaryTree(nodes);
      node.right = buildBinaryTree(nodes);
      return node;
    }
  }
}
