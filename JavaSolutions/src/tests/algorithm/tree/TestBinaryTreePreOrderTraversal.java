package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBinaryTreePreOrderTraversal {
  public static TreeNode leaf = new TreeNode(3);
  public static TreeNode treeOne = new TreeNode(3);
  public static TreeNode treeTwo = new TreeNode(10);
  public static TreeNode danglingTree = new TreeNode(5);

  public static List<Integer> resultNull = new ArrayList<>();
  public static List<Integer> resultLeaf = new ArrayList<>();
  public static List<Integer> resultOne = new ArrayList<>();
  public static List<Integer> resultTwo = new ArrayList<>();
  public static List<Integer> resultDanglingTree = new ArrayList<>();

  @BeforeTest
  public void setup() {
    treeOne.left = new TreeNode(9);
    treeOne.right = new TreeNode(20);
    treeOne.right.left = new TreeNode(15);
    treeOne.right.right = new TreeNode(7);

    treeTwo.left = new TreeNode(8);
    treeTwo.right = new TreeNode(12);

    danglingTree.left = new TreeNode(4);
    danglingTree.left.left = new TreeNode(3);

    resultLeaf.add(leaf.val);

    resultOne = Arrays.asList(new Integer[] {3, 9, 20, 15, 7});

    resultTwo = Arrays.asList(new Integer[] {10, 8, 12});

    resultDanglingTree = Arrays.asList(new Integer[] {5, 4, 3});
  }

  @Test
  public void testNullCase() {
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalRecursively(null), resultNull);
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalIteratively(null), resultNull);
  }

  @Test
  public void testLeafCase() {
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalRecursively(leaf), resultLeaf);
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalIteratively(leaf), resultLeaf);

    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversal(leaf), resultLeaf);
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalRecursively(treeOne), resultOne);
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalIteratively(treeOne), resultOne);

    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalRecursively(treeTwo), resultTwo);
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalIteratively(treeTwo), resultTwo);
  }

  @Test
  public void testDanglingTree() {
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalRecursively(danglingTree), resultDanglingTree);
    Assert.assertEquals(BinaryTreePreOrderTraversal.preorderTraversalIteratively(danglingTree), resultDanglingTree);
  }
}
