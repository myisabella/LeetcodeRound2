package algorithm.bitmanipulation;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Unit test for number of one bits
 * 1. 0 => 0
 * 2. 1 => 1
 * 3. (1011)b => 3
 * 4. Max integer => 31
 */
public class TestNumberOfOneBits {

  private NumberOfOneBits e = new NumberOfOneBits();

  @Test()
  public void testNumberOfOneBitsWithZero() {
    Assert.assertEquals(e.hammingWeight(0), 0, "Number of one bits for 0 should be 0");
  }

  @Test()
  public void testNumberOfOneBitsWithOne() {
    Assert.assertEquals(e.hammingWeight(1), 1, "Number of one bits for 1 should be 1");
  }

  @Test()
  public void testNumberOfOneBitsWithCommonNumbers() {
    Assert.assertEquals(e.hammingWeight(11), 3, "Number of one bits for 1011 should be 3");
    Assert.assertEquals(e.hammingWeight(3), 2, "Number of one bits for 011 should be 2");
  }

  @Test()
  public void testNumberOfOneBitsWithLargeNumber() {
    Assert.assertEquals(e.hammingWeight(2147483647), 31, "Number of one bits for max integer should be 31");
  }
}
