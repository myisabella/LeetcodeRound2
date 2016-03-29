package algorithm.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEvaluateReversePolishNotation {
  private String[] emptyToken = {};
  private String[] singleToken = {"2"};
  private String[] tokens1 = {"2", "1", "+", "3", "*"};
  private String[] tokens2 = {"4", "13", "5", "/", "+"};
  private String[] tokens3 = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};

  @Test
  public void testEmptyTokenCase() {
    Assert.assertEquals(EvaluateReversePolishNotation.evalRPN(emptyToken), 0);
  }

  @Test
  public void testSingleTokenCase() {
    Assert.assertEquals(EvaluateReversePolishNotation.evalRPN(singleToken), 2);
  }

  @Test
  public void testGeneralCases() {
    Assert.assertEquals(EvaluateReversePolishNotation.evalRPN(tokens1), 9);
    Assert.assertEquals(EvaluateReversePolishNotation.evalRPN(tokens2), 6);
    Assert.assertEquals(EvaluateReversePolishNotation.evalRPN(tokens3), 14);
  }
}
