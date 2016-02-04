package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestPathSum {
  private static TreeNode leaf = new TreeNode(3);
  private static TreeNode root = new TreeNode(5);

  @BeforeTest
  public void setup() {
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);
  }

  @Test
  public void testNullTree() {
    Assert.assertFalse(PathSum.hasPathSumRecursive(null, 1));
    Assert.assertFalse(PathSum.hasPathSumIterative(null, 1));
  }

  @Test
  public void testLeafTree() {
    Assert.assertTrue(PathSum.hasPathSumRecursive(leaf, 3));
    Assert.assertTrue(PathSum.hasPathSumIterative(leaf, 3));

    Assert.assertFalse(PathSum.hasPathSumRecursive(leaf, 2));
    Assert.assertFalse(PathSum.hasPathSumIterative(leaf, 2));
  }

  @Test
  public void testNormalTree() {
    Assert.assertTrue(PathSum.hasPathSumRecursive(root, 22));
    Assert.assertTrue(PathSum.hasPathSumIterative(root, 22));

    Assert.assertFalse(PathSum.hasPathSumRecursive(root, 101));
    Assert.assertFalse(PathSum.hasPathSumIterative(root, 101));
  }
}
