package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestMaxDepthOfBinaryTree {
  private static TreeNode leaf = new TreeNode(3);
  private static TreeNode balancedBinaryTree = new TreeNode(2);
  private static TreeNode unbalancedBinaryTree = new TreeNode(1);

  @BeforeTest
  public void setup() {
    balancedBinaryTree.left = new TreeNode(7);
    balancedBinaryTree.left.left = new TreeNode(2);
    balancedBinaryTree.left.right = new TreeNode(6);
    balancedBinaryTree.right = new TreeNode(5);

    unbalancedBinaryTree.left = new TreeNode(2);
    unbalancedBinaryTree.left.left = new TreeNode(3);
    unbalancedBinaryTree.left.left.left = new TreeNode(4);
  }

  @Test
  public void testNullNode() {
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthRecursive(null), 0, "The max depth of null should be zero");
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthIterative(null), 0, "The max depth of null should be zero");
  }

  @Test
  public void testLeafNode() {
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthRecursive(leaf), 1, "The max depth of leaf should be 1");
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthIterative(leaf), 1, "The max depth of leaf should be 1");
  }

  @Test
  public void testBalancedBinaryTree() {
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthRecursive(balancedBinaryTree), 3);
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthIterative(balancedBinaryTree), 3);
  }

  @Test
  public void testUnbalancedBinaryTree() {
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthRecursive(unbalancedBinaryTree), 4);
    Assert.assertEquals(MaxDepthOfBinaryTree.maxDepthIterative(unbalancedBinaryTree), 4);
  }
}
