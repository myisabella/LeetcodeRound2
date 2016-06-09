package algorithm.combination;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSubsets {
  private int[] nullArray = null;
  private int[] emptyArray = new int[] {};
  private int[] nums1 = new int[] {1};
  private int[] nums2 = new int[] {1, 2, 3};

  private List<List<Integer>> emptySubsets = new ArrayList<>();
  private List<List<Integer>> res1 = new ArrayList<>();
  private List<List<Integer>> res2 = new ArrayList<>();

  @BeforeTest
  public void setup() {
    
  }

  @Test
  public void testNullArray() {
    Assert.assertEquals(Subsets.subsets(nullArray), emptySubsets);
  }

  @Test
  public void testEmptyArray() {
    Assert.assertEquals(Subsets.subsets(emptyArray), emptySubsets);
  }

  @Test
  public void test() {
    List<List<Integer>> res2 = Subsets.subsets(nums2);
  }
}
