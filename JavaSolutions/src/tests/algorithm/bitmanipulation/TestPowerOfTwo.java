package algorithm.bitmanipulation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for majority element
 * 1. Input is zero -> return value should be false
 * 2. Input is negative number -> return value should be false
 * 3. Input is 1 -> return value should be true
 * 4. Input is a number that is power of 2, e.g. 16 -> return value should be true
 */
public class TestPowerOfTwo {

  private PowerOfTwo p = new PowerOfTwo();

  @Test()
  public void testPowerOfTwoWithZero() {
    Assert.assertFalse(p.isPowerOfTwo(0), "zero is not power of two");
  }

  @Test()
  public void testPowerOfTwoWithNegativeNumber() {
    Assert.assertFalse(p.isPowerOfTwo(-1), "-1 is not power of two");
    Assert.assertFalse(p.isPowerOfTwo(-16), "-16 is not power of two");
  }

  @Test()
  public void testPowerOfTwoWithOne() {
    Assert.assertTrue(p.isPowerOfTwo(1), "1 is power of two");
  }

  @Test()
  public void testPowerOfTwoWithSixteen() {
    Assert.assertTrue(p.isPowerOfTwo(16), "16 is power of two");
  }
}
