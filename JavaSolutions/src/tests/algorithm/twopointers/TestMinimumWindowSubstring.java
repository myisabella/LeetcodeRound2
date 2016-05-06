package algorithm.twopointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMinimumWindowSubstring {

  @Test
  public void testEmptyString() {
    Assert.assertEquals(MinimumWindowSubstring.minWindow("", ""), "");
  }

  @Test
  public void testLongerTargetString() {
    Assert.assertEquals(MinimumWindowSubstring.minWindow("abc", "abcd"), "");
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(MinimumWindowSubstring.minWindow("BANCFBD", "ABC"), "BANC");
  }
}
