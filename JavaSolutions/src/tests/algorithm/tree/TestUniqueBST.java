package algorithm.tree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUniqueBST {

  @Test
  public void testBaseCase() {
    Assert.assertEquals(UniqueBST.numTrees(0), 1);
    Assert.assertEquals(UniqueBST.numTrees(1), 1);
  }

  @Test
  public void testGeneralCase() {
    Assert.assertEquals(UniqueBST.numTrees(3), 5);
  }
}
