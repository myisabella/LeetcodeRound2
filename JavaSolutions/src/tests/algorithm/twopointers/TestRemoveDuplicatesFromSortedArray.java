package algorithm.twopointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRemoveDuplicatesFromSortedArray {

  private int[] empty = new int[0];
  private int[] single = new int[] {1};
  private int[] array1 = new int[] {1, 1, 1, 2, 2, 3};

  @Test
  public void testNullOrEmptyCase() {
    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicates(null), 0);
    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicates(empty), 0);

    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicatesTwice(null), 0);
    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicatesTwice(empty), 0);
  }

  @Test
  public void testSingleElementArray() {
    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicates(single), 1);
    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicatesTwice(single), 1);
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicatesTwice(array1), 5);
//    Assert.assertEquals(RemoveDuplicatesFromSortedArray.removeDuplicatesTwiceII(array1), 5);
  }
}
