package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestLCAofBST {
  private TreeNode node = new TreeNode(6);
  private TreeNode p = new TreeNode(2);
  private TreeNode q = new TreeNode(8);

  @BeforeTest
  public void setup() {
    node.left = p;
    node.left.left = new TreeNode(0);
    node.left.right = new TreeNode(4);
    node.left.right.left = new TreeNode(3);
    node.left.right.right = new TreeNode(5);
    node.right = q;
    node.right.left = new TreeNode(7);
    node.right.right = new TreeNode(9);
  }

  @Test
  public void test() {
    Assert.assertEquals(LCAofBST.lowestCommonAncestor(node, p, q), node);
    Assert.assertEquals(LCAofBST.lowestCommonAncestor(node, node, q), node);
    Assert.assertEquals(LCAofBST.lowestCommonAncestor(node, p, node), node);
  }
}
