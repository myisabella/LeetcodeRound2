package algorithm.twopointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestImplementstrStr {

  @Test
  public void testEmptyStrings() {
    Assert.assertEquals(ImplementstrStr.strStr("", ""), 0);
  }

  @Test
  public void testNeedleIsNotInHaystack() {
    Assert.assertEquals(ImplementstrStr.strStr("abc", "defg"), -1);
    Assert.assertEquals(ImplementstrStr.strStr("abc", "e"), -1);
  }

  @Test
  public void testNeedleIsInHaystack() {
    Assert.assertEquals(ImplementstrStr.strStr("thisisanapple", "apple"), 8);
    Assert.assertEquals(ImplementstrStr.strStr("here is an apple tree, which has many apples", "apple"), 11);
  }
}
