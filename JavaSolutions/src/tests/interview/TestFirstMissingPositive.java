package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFirstMissingPositive {

  @Test
  public void test() {
    int[] nums1 = { 3, 1, -1, 0};
    Assert.assertEquals(FirstMissingPositive.firstMissingPositive(nums1), 2);

    int[] nums2 = { 1, 1, 2, 3, 5};
    Assert.assertEquals(FirstMissingPositive.firstMissingPositive(nums2), 4);

    int[] nums3 = { -3, -2, -1 };
    Assert.assertEquals(FirstMissingPositive.firstMissingPositive(nums3), 1);

    int[] nums4 = {};
    Assert.assertEquals(FirstMissingPositive.firstMissingPositive(nums4), 1);
  }
}
