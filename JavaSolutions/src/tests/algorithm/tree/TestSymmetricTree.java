package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSymmetricTree {
  private static TreeNode leaf = new TreeNode(3);
  private static TreeNode root = new TreeNode(1);

  @BeforeTest
  public void setup() {
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
  }

  @Test
  public void testNullTree() {
    Assert.assertTrue(SymmetricTree.isSymmetricRecursive(null));
    Assert.assertTrue(SymmetricTree.isSymmetricIterative(null));
  }

  @Test
  public void testLeafTree() {
    Assert.assertTrue(SymmetricTree.isSymmetricRecursive(leaf));
    Assert.assertTrue(SymmetricTree.isSymmetricIterative(leaf));
  }

  @Test
  public void testNormalTree() {
    Assert.assertTrue(SymmetricTree.isSymmetricRecursive(root));
    Assert.assertTrue(SymmetricTree.isSymmetricIterative(root));
  }
}
