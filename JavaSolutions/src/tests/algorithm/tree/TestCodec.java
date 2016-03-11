package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCodec {
  private Codec codec = new Codec();
  private TreeNode leaf = new TreeNode(1);
  private TreeNode treeOne = new TreeNode(1);

  private String nullString = "#";
  private String leafString = "1,#,#";
  private String treeOneString = "1,2,#,#,3,4,#,#,5,#,#";

  @BeforeTest
  public void setup() {
    treeOne.left = new TreeNode(2);
    treeOne.right = new TreeNode(3);
    treeOne.right.left = new TreeNode(4);
    treeOne.right.right = new TreeNode(5);
  }

  @Test
  public void testNullCase() {
    Assert.assertEquals(codec.serialize(null), nullString);
    TreeNode buildNullTree = codec.deserialize(nullString);
    Assert.assertTrue(SameTree.isSameTree(buildNullTree, null));
  }

  @Test
  public void testLeafCase() {
    Assert.assertEquals(codec.serialize(leaf), leafString);
    TreeNode buildLeafTree = codec.deserialize(leafString);
    Assert.assertTrue(SameTree.isSameTree(buildLeafTree, leaf));
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(codec.serialize(treeOne), treeOneString);
    TreeNode buildTreeOne = codec.deserialize(treeOneString);
    Assert.assertTrue(SameTree.isSameTree(buildTreeOne, treeOne));
  }
}
