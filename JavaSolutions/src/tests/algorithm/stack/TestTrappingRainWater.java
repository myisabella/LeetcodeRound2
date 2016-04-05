package algorithm.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTrappingRainWater {
  int[] empty = new int[0];
  int[] single = { 1 };
  int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
  int[] height2 = { 1, 1 };
  int[] height3 = { 0, 1, 2, 3, 4, 4 };

  @Test
  public void testEmptyCase() {
    Assert.assertEquals(TrappingRainWater.trapWithStack(empty), 0, "Empty case should return 0");
    Assert.assertEquals(TrappingRainWater.trapWithTwoPointers(empty), 0, "Empty case should return 0");
  }

  @Test
  public void testSingleHeightCase() {
    Assert.assertEquals(TrappingRainWater.trapWithStack(single), 0);
    Assert.assertEquals(TrappingRainWater.trapWithTwoPointers(single), 0);
  }

  @Test
  public void testNormalCases() {
    Assert.assertEquals(TrappingRainWater.trapWithStack(height1), 6);
    Assert.assertEquals(TrappingRainWater.trapWithTwoPointers(height1), 6);

    Assert.assertEquals(TrappingRainWater.trapWithStack(height2), 0);
    Assert.assertEquals(TrappingRainWater.trapWithTwoPointers(height2), 0);

    Assert.assertEquals(TrappingRainWater.trapWithStack(height3), 0);
    Assert.assertEquals(TrappingRainWater.trapWithTwoPointers(height3), 0);
  }
}
