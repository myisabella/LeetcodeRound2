package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestSameTree {
  private static TreeNode leafNode = new TreeNode(0);
  private static TreeNode node1 = new TreeNode(1);
  private static TreeNode node2 = new TreeNode(2);
  private TreeNode treeA = new TreeNode(3);
  private TreeNode treeB = new TreeNode(4);

  @Test()
  public void testSameNullTree() {
    Assert.assertTrue(SameTree.isSameTree(null, null));
  }

  @Test()
  public void testOneSameLeaf() {
    Assert.assertTrue(SameTree.isSameTree(leafNode, leafNode));
  }

  @Test()
  public void testOneNullTree() {
    Assert.assertFalse(SameTree.isSameTree(leafNode, null));
  }

  @Test()
  public void testSameTree() {
    treeA.left = node1;
    treeA.right = node2;

    Assert.assertTrue(SameTree.isSameTree(treeA, treeA));
  }

  @Test()
  public void testNonSameTree() {
    treeA.left = node1;
    treeA.right = node2;
    treeB.left = node1;
    treeB.right = node2;

    Assert.assertFalse(SameTree.isSameTree(treeA, treeB));
  }
}
