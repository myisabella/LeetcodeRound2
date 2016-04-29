package algorithm.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLargestRectangleHistogram {

  @Test
  public void test() {
    int[] heights = { 4, 3, 4, 3 };
    Assert.assertEquals(LargestRectangleInHistogram.largestRectangleArea(heights), 12);
  }
}
