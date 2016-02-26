package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBinaryTreeInOrderTraversal {
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

    resultTwo = Arrays.asList(new Integer[]{1, 3, 2});

    resultDanglingTree = Arrays.asList(new Integer[]{3, 4, 5});
  }

  @Test
  public void testNullCase() {
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalRecursively(null), resultNull);
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalIteratively(null), resultNull);
  }

  @Test
  public void testLeafCase() {
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalRecursively(leaf), resultLeaf);
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalIteratively(leaf), resultLeaf);
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalIteratively(treeOne), resultOne);
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalRecursively(treeOne), resultOne);

    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalIteratively(treeTwo), resultTwo);
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalRecursively(treeTwo), resultTwo);
  }

  @Test
  public void testDanglingTree() {
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalIteratively(danglingTree), resultDanglingTree);
    Assert.assertEquals(BinaryTreeInOrderTraversal.inorderTraversalRecursively(danglingTree), resultDanglingTree);
  }
}
