package algorithm.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVerifyPreorderSerializationOfABinaryTree {
  private String leaf = "#";
  private String preorder1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
  private String preorder2 = "1,#";
  private String preorder3 = "9,#,#,1";

  @Test
  public void testNullCase() {
    Assert.assertFalse(VerifyPreorderSerializationOfABinaryTree.isValidSerialization(null));
  }

  @Test
  public void testLeafCase() {
    Assert.assertTrue(VerifyPreorderSerializationOfABinaryTree.isValidSerialization(leaf));
  }

  @Test
  public void testGeneralCases() {
    Assert.assertTrue(VerifyPreorderSerializationOfABinaryTree.isValidSerialization(preorder1));
    Assert.assertFalse(VerifyPreorderSerializationOfABinaryTree.isValidSerialization(preorder2));
    Assert.assertFalse(VerifyPreorderSerializationOfABinaryTree.isValidSerialization(preorder3));
  }
}
