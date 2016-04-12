package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestReversedListFromArray {
  ReversedListFromArray rlfa = new ReversedListFromArray();

  @Test
  public void testEmptyArray() {
    Integer[] empty = {};
    int[] emptyint = {};
    List<Integer> emptyList = new ArrayList<>();

    Assert.assertEquals(rlfa.getReversedListFromArray(empty), emptyList);
    Assert.assertEquals(rlfa.getReversedListFromArray(emptyint), emptyList);
  }

  @Test
  public void testSingleElementArray() {
    Integer[] single = { 2 };
    int[] singleint = { 2 };
    List<Integer> singleList = new ArrayList<>();
    singleList.add(single[0]);

    Assert.assertEquals(rlfa.getReversedListFromArray(single), singleList);
    Assert.assertEquals(rlfa.getReversedListFromArray(singleint), singleList);
  }

  @Test
  public void testTwoElementsArray() {
    Integer[] twoElemArray = { 1, 2 };
    int[] twoElemArrayint = { 1, 2 };
    List<Integer> twoElemList = new ArrayList<>();
    twoElemList.add(2);
    twoElemList.add(1);

    Assert.assertEquals(rlfa.getReversedListFromArray(twoElemArray), twoElemList);
    Assert.assertEquals(rlfa.getReversedListFromArray(twoElemArrayint), twoElemList);
  }

  @Test
  public void testMultipleElementsArray() {
    Integer[] multipleElemArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    List<Integer> multipleElemList = new ArrayList<>();
    for (int i = multipleElemArray.length - 1; i >= 0; i--) {
      multipleElemList.add(multipleElemArray[i]);
    }

    Assert.assertEquals(rlfa.getReversedListFromArray(multipleElemArray), multipleElemList);
  }
}
