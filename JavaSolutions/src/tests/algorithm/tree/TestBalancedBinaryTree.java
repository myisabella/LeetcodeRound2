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
  private static TreeNode p = new TreeNode(2);

  @BeforeTest
  public void setup() {
    balancedRoot.left = new TreeNode(5);
    balancedRoot.left.left = new TreeNode(2);
    balancedRoot.left.right = new TreeNode(7);
    balancedRoot.right = new TreeNode(8);

    unbalancedRoot.left = new TreeNode(5);
    unbalancedRoot.left.left = new TreeNode(2);
    unbalancedRoot.left.right = new TreeNode(7);

    p.left = new TreeNode(7);
    p.left.left = new TreeNode(2);
    p.left.right = new TreeNode(6);
    p.left.right.left = new TreeNode(5);
    p.left.right.right = new TreeNode(11);
    p.right = new TreeNode(5);
    p.right.right = new TreeNode(9);
    p.right.right.left = new TreeNode(4);
  }

  @Test
  public void testNullTree() {
    Assert.assertTrue(BalancedBinaryTree.isBalancedTopDown(null));
    Assert.assertTrue(BalancedBinaryTree.isBalancedBottomUp(null));
  }

  @Test
  public void testLeafNode() {
    Assert.assertTrue(BalancedBinaryTree.isBalancedTopDown(leafNode));
    Assert.assertTrue(BalancedBinaryTree.isBalancedBottomUp(leafNode));
  }

  @Test
  public void testBalancedTree() {
    Assert.assertTrue(BalancedBinaryTree.isBalancedTopDown(balancedRoot));
    Assert.assertTrue(BalancedBinaryTree.isBalancedBottomUp(balancedRoot));
  }

  @Test
  public void testUnbalancedTree() {
    Assert.assertFalse(BalancedBinaryTree.isBalancedTopDown(unbalancedRoot));
    Assert.assertFalse(BalancedBinaryTree.isBalancedBottomUp(unbalancedRoot));
  }

  @Test
  public void testUnbalancedTree2() {
    Assert.assertFalse(BalancedBinaryTree.isBalancedTopDown(p));
    Assert.assertFalse(BalancedBinaryTree.isBalancedBottomUp(p));
  }
}
