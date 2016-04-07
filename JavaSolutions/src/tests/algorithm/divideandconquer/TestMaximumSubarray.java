package algorithm.divideandconquer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMaximumSubarray {
  int[] empty = new int[0];
  int[] single = { 1 };
  int[] duplicate = { 1, 1 };
  int[] array1 = { 1, 2, 3 };
  int[] array2 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
  int[] array3 = { -3, -1, -2 };

  @Test
  public void testEmptyCase() {
    Assert.assertEquals(MaximumSubarray.maxSubArrayGreedy(empty), 0);
    Assert.assertEquals(MaximumSubarray.maxSubArrayDAC(empty), 0);
  }

  @Test
  public void testSingleElementCase() {
    Assert.assertEquals(MaximumSubarray.maxSubArrayGreedy(single), 1);
    Assert.assertEquals(MaximumSubarray.maxSubArrayDAC(single), 1);
  }

  @Test
  public void testDuplicateElementsCase() {
    Assert.assertEquals(MaximumSubarray.maxSubArrayGreedy(duplicate), 2);
    Assert.assertEquals(MaximumSubarray.maxSubArrayDAC(duplicate), 2);
  }

  @Test
  public void testGeneralCases() {
    // All elements are positive
    Assert.assertEquals(MaximumSubarray.maxSubArrayGreedy(array1), 6);
    Assert.assertEquals(MaximumSubarray.maxSubArrayDAC(array1), 6);

    // There are positive and negative elements
    Assert.assertEquals(MaximumSubarray.maxSubArrayGreedy(array2), 6);
    Assert.assertEquals(MaximumSubarray.maxSubArrayDAC(array2), 6);

    // All elements are negative
    Assert.assertEquals(MaximumSubarray.maxSubArrayGreedy(array3), -1);
    Assert.assertEquals(MaximumSubarray.maxSubArrayDAC(array3), -1);
  }
}
