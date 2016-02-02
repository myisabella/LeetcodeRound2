package algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Test cases:
 * (1) null
 * (2) one element tree
 * (3) some normal binary tree
 * (4) dangling tree
 */
public class TestBinaryTreeLevelOrderTraversal {
  public static TreeNode leaf = new TreeNode(3);
  public static TreeNode treeOne = new TreeNode(3);
  public static TreeNode treeTwo = new TreeNode(10);
  public static TreeNode danglingTree = new TreeNode(5);

  public static List<List<Integer>> resultLeaf = new LinkedList<>();
  public static List<List<Integer>> resultOne = new LinkedList<>();
  public static List<List<Integer>> resultTwo = new LinkedList<>();
  public static List<List<Integer>> resultDanglingTree = new LinkedList<>();

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

    List<Integer> leafList = new LinkedList<>();
    leafList.add(leaf.val);
    resultLeaf.add(leafList);

    List<Integer> treeOneLevelOne = new LinkedList<>();
    treeOneLevelOne.add(treeOne.val);
    resultOne.add(treeOneLevelOne);
    List<Integer> treeOneLevelTwo = new LinkedList<>();
    treeOneLevelTwo.add(treeOne.left.val);
    treeOneLevelTwo.add(treeOne.right.val);
    resultOne.add(treeOneLevelTwo);
    List<Integer> treeOneLevelThree = new LinkedList<>();
    treeOneLevelThree.add(treeOne.right.left.val);
    treeOneLevelThree.add(treeOne.right.right.val);
    resultOne.add(treeOneLevelThree);

    List<Integer> treeTwoLevelOne = new LinkedList<>();
    treeTwoLevelOne.add(treeTwo.val);
    resultTwo.add(treeTwoLevelOne);
    List<Integer> treeTwoLevelTwo = new LinkedList<>();
    treeTwoLevelTwo.add(treeTwo.left.val);
    treeTwoLevelTwo.add(treeTwo.right.val);
    resultTwo.add(treeTwoLevelTwo);

    List<Integer> danglingTreeLevelOne = new LinkedList<>();
    danglingTreeLevelOne.add(danglingTree.val);
    List<Integer> danglingTreeLevelTwo = new LinkedList<>();
    danglingTreeLevelTwo.add(danglingTree.left.val);
    List<Integer> danglingTreeLevelThree = new LinkedList<>();
    danglingTreeLevelThree.add(danglingTree.left.left.val);
    resultDanglingTree.add(danglingTreeLevelOne);
    resultDanglingTree.add(danglingTreeLevelTwo);
    resultDanglingTree.add(danglingTreeLevelThree);
  }

  @Test
  public void testNullTreeLevelOrderTraversal() {
    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderBFS(null), new LinkedList<List<Integer>>(),
        "Null tree level order traversal should return empty list");

    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderDFS(null), new LinkedList<List<Integer>>(),
        "Null tree level order traversal should return empty list");
  }

  @Test
  public void testOneElementTreeLevelOrderTraversal() {
    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderBFS(leaf), resultLeaf);

    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderDFS(leaf), resultLeaf);
  }

  @Test
  public void testNormalBinaryTreeLevelOrderTraversal() {
    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderBFS(treeOne), resultOne);
    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderBFS(treeTwo), resultTwo);

    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderDFS(treeOne), resultOne);
    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderDFS(treeTwo), resultTwo);
  }

  @Test
  public void testDanglingTreeLevelOrderTraversal() {
    Assert.assertEquals(BinaryTreeLevelOrderTraversal.levelOrderBFS(danglingTree), resultDanglingTree);
  }
}
