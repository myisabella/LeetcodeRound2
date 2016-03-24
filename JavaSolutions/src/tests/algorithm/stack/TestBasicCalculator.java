package algorithm.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBasicCalculator {

  @Test
  public void testSimpleCases() {
    Assert.assertEquals(BasicCalculator.calculate("1 + 1"), 2);
    Assert.assertEquals(BasicCalculator.calculate(" 1+  2  "), 3);
    Assert.assertEquals(BasicCalculator.calculate("11 + 12 "), 23);
  }
}
