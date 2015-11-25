package algorithm.bitmanipulation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for majority element
 * 1. Array with only one element -> majority element is the element
 * 2. Array with same element -> majority element is the element
 * 3. Normal array, [1, 2, 3, 4, 1] -> majority element is 1
 */
public class TestMajorityElement {
  private MajorityElement e = new MajorityElement();

  @Test()
  public void testMajorityElementWithOneElementArray() {
    int[] arr = { 1 };
    Assert.assertEquals(e.majorityElement(arr), 1, "The majority element in one element array should be itself");
  }

  @Test()
  public void testMajorityElementWithSameElementArray() {
    int[] arr = { 1, 1, 1, 1, 1 };
    Assert.assertEquals(e.majorityElement(arr), 1, "The majority element in same element array should be itself");
  }

  @Test()
  public void testMajorityElementWithNormalArray() {
    int[] arr = { 1, 2, 3, 4, 1 };
    Assert.assertEquals(e.majorityElement(arr), 1, "The majority element in normal array should be the correct one");
  }
}
