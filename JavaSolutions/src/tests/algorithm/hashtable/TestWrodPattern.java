package algorithm.hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWrodPattern {
  String pattern1 = "abba";
  String pattern2 = "aaaa";

  String str1 = "dog cat cat dog";
  String str2 = "dog cat cat fish";
  String str3 = "dog dog dog dog";

  @Test
  public void testGeneralCases() {
    Assert.assertTrue(WordPattern.wordPattern(pattern1, str1));
    Assert.assertFalse(WordPattern.wordPattern(pattern1, str2));
    Assert.assertFalse(WordPattern.wordPattern(pattern2, str1));
    Assert.assertFalse(WordPattern.wordPattern(pattern1, str3));
  }
}
