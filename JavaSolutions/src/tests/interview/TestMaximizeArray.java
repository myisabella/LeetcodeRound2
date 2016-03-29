package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMaximizeArray {
  int[] input1 = {1, 2};
  int[] input2 = {2, 1, 1, 2};

  int res1 = 3;
  int res2 = 9;

  @Test
  public void testBaseCases() {
    Assert.assertEquals(MaximizeArray.findMaxOperation(input1), res1);
  }

  @Test
  public void testSimpleCases() {
    Assert.assertEquals(MaximizeArray.findMaxOperation(input2), res2);
  }
}
