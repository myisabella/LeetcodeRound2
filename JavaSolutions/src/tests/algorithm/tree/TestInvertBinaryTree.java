package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestInvertBinaryTree {
  private static TreeNode leaf = new TreeNode(1);
  private static TreeNode tree = new TreeNode(4);
  private static TreeNode resultTree = new TreeNode(4);

  @BeforeTest
  public void setup() {
    // set up tree
    tree.left = new TreeNode(2);
    tree.left.left = new TreeNode(1);
    tree.left.right = new TreeNode(3);
    tree.right = new TreeNode(7);
    tree.right.left = new TreeNode(6);
    tree.right.right = new TreeNode(9);

    // set up expected result
    resultTree.left = new TreeNode(7);
    resultTree.left.left = new TreeNode(9);
    resultTree.left.right = new TreeNode(6);
    resultTree.right = new TreeNode(2);
    resultTree.right.left = new TreeNode(3);
    resultTree.right.right = new TreeNode(1);
  }

  @Test
  public void testNull() {
    Assert.assertEquals(InvertBinaryTree.invertTreeRecursive(null), null, "Invert null should return null");
    Assert.assertEquals(InvertBinaryTree.invertTreeIterative(null), null, "Invert null should return null");
  }

  @Test
  public void testLeafNode() {
    Assert.assertEquals(InvertBinaryTree.invertTreeRecursive(leaf), leaf, "Invert leaf node should return itself");
    Assert.assertEquals(InvertBinaryTree.invertTreeIterative(leaf), leaf, "Invert leaf node should return itself");
  }

  @Test
  public void testNormalBinaryTree() {
    Assert.assertTrue(SameTree.isSameTree(InvertBinaryTree.invertTreeRecursive(tree), resultTree),
        "The inverted tree does not match expected result");
    setup();
    Assert.assertTrue(SameTree.isSameTree(InvertBinaryTree.invertTreeIterative(tree), resultTree),
        "The inverted tree does not match expected result");
  }
}
