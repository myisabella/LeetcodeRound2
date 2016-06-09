package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRemoveConsecutiveChars {

  private String nullStr = null;
  private String empty = "";
  private String str1 = "abbc";
  private String str2 = "aa";
  private String str3 = "acccbdd";
  private String str4 = "abbabb";

  private String res1 = "ac";
  private String res2 = "";
  private String res3 = "ab";
  private String res4 = "";

  @Test
  public void testNullCase() {
    Assert.assertEquals(RemoveConsecutiveChars.removeConsecutiveChars(nullStr), empty);
  }

  @Test
  public void testEmptyCase() {
    Assert.assertEquals(RemoveConsecutiveChars.removeConsecutiveChars(empty), empty);
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(RemoveConsecutiveChars.removeConsecutiveChars(str1), res1);
    Assert.assertEquals(RemoveConsecutiveChars.removeConsecutiveChars(str2), res2);
    Assert.assertEquals(RemoveConsecutiveChars.removeConsecutiveChars(str3), res3);
    Assert.assertEquals(RemoveConsecutiveChars.removeConsecutiveChars(str4), res4);
  }
}
