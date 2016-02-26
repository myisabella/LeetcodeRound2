package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBinaryTreePostOrderTraversal {
  public static TreeNode leaf = new TreeNode(3);
  public static TreeNode treeOne = new TreeNode(1);
  public static TreeNode treeTwo = new TreeNode(1);
  public static TreeNode danglingTree = new TreeNode(5);

  public static List<Integer> resultNull = new ArrayList<>();
  public static List<Integer> resultLeaf = new ArrayList<>();
  public static List<Integer> resultOne = new ArrayList<>();
  public static List<Integer> resultTwo = new ArrayList<>();
  public static List<Integer> resultDanglingTree = new ArrayList<>();

  @BeforeTest
  public void setup() {
    treeOne.left = new TreeNode(2);
    treeOne.right = new TreeNode(3);
    treeOne.left.left = new TreeNode(4);
    treeOne.left.right = new TreeNode(5);

    treeTwo.right = new TreeNode(2);
    treeTwo.right.left = new TreeNode(3);

    danglingTree.left = new TreeNode(4);
    danglingTree.left.left = new TreeNode(3);

    resultLeaf.add(leaf.val);

    resultOne = Arrays.asList(new Integer[]{4, 2, 5, 1, 3});

    resultTwo = Arrays.asList(new Integer[]{3, 2, 1});

    resultDanglingTree = Arrays.asList(new Integer[]{3, 4, 5});
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(BinaryTreePostOrderTraversal.postorderTraversalIteratively(treeTwo), resultTwo);
  }
}
