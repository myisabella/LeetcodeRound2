package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Test cases: null, leaf node, balanced, unbalanced
 */
public class TestBalancedBinaryTree {
  private static TreeNode leafNode = new TreeNode(0);
  private static TreeNode balancedRoot = new TreeNode(4);
  private static TreeNode unbalancedRoot = new TreeNode(4);

  @BeforeTest
  public void setup() {
    balancedRoot.left = new TreeNode(5);
    balancedRoot.left.left = new TreeNode(2);
    balancedRoot.left.right = new TreeNode(7);
    balancedRoot.right = new TreeNode(8);

    unbalancedRoot.left = new TreeNode(5);
    unbalancedRoot.left.left = new TreeNode(2);
    unbalancedRoot.left.right = new TreeNode(7);
  }

  @Test
  public void testNullTree() {
    Assert.assertTrue(BalancedBinaryTree.isBalanced(null));
  }

  @Test
  public void testLeafNode() {
    Assert.assertTrue(BalancedBinaryTree.isBalanced(leafNode));
  }

  @Test
  public void testBalancedTree() {
    Assert.assertTrue(BalancedBinaryTree.isBalanced(balancedRoot));
  }

  @Test
  public void testUnbalancedTree() {
    Assert.assertFalse(BalancedBinaryTree.isBalanced(unbalancedRoot));
  }
}
