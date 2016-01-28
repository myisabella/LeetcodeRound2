package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBSTIterator {
  private BSTIterator _iterator;
  private TreeNode root;
  private int[] expected = {4, 5, 6, 8, 10, 11, 17, 19, 31, 43, 49};

  @BeforeTest
  public void setup() {
    root = new TreeNode(11);
    root.left = new TreeNode(6);
    root.left.left = new TreeNode(4);
    root.left.left.right = new TreeNode(5);
    root.left.right = new TreeNode(8);
    root.left.right.right = new TreeNode(10);
    root.right = new TreeNode(19);
    root.right.left = new TreeNode(17);
    root.right.right = new TreeNode(43);
    root.right.right.left = new TreeNode(31);
    root.right.right.right = new TreeNode(49);

    _iterator = new BSTIterator(root);
  }

  @Test
  public void testSmallestNumber() {
    int i = 0;

    while (_iterator.hasNext()) {
      int actual = _iterator.next();
      Assert.assertEquals(actual, expected[i],
          "The smallest number should be " + expected[i] + " while actual value is " + actual);
      i++;
    }
  }
}
