package algorithm.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestValidParentheses {

  @Test
  public void testBasicCases() {
    Assert.assertTrue(ValidParentheses.isValid("()"));
    Assert.assertTrue(ValidParentheses.isValid("[]"));
    Assert.assertTrue(ValidParentheses.isValid("{}"));

    Assert.assertFalse(ValidParentheses.isValid("(["));
  }

  @Test
  public void testComplexCases() {
    Assert.assertTrue(ValidParentheses.isValid("()[]{}"));
    Assert.assertTrue(ValidParentheses.isValid("([{}])"));

    Assert.assertFalse(ValidParentheses.isValid("([)]"));
  }
}
