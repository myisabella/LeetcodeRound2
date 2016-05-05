package algorithm.twopointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLongestSubstringWithoutRepeating {

  @Test
  public void testNullOrEmptyString() {
    Assert.assertEquals(LongestSubstringWithoutRepeating.lengthOfLongestSubstring(null), 0);
    Assert.assertEquals(LongestSubstringWithoutRepeating.lengthOfLongestSubstring(""), 0);
  }

  @Test
  public void testNonRepeatingString() {
    Assert.assertEquals(LongestSubstringWithoutRepeating.lengthOfLongestSubstring("abc"), 3);
  }

  @Test
  public void testPartialRepeatingStrings() {
    Assert.assertEquals(LongestSubstringWithoutRepeating.lengthOfLongestSubstring("abcabcbc"), 3);
    Assert.assertEquals(LongestSubstringWithoutRepeating.lengthOfLongestSubstring("pwwkew"), 3);
  }

  @Test
  public void testAllRepeatingString() {
    Assert.assertEquals(LongestSubstringWithoutRepeating.lengthOfLongestSubstring("bbbbbb"), 1);
  }
}
