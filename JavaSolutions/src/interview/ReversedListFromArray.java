package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provide a function that takes an array of integers and returns a reversed version of the list.
 */
public class ReversedListFromArray {
  public List<Integer> getReversedListFromArray(Integer[] array) {
    List<Integer> list = Arrays.asList(array);
    Collections.reverse(list);
    return list;
  }

  /**
   *
   * @param array
   * @return
   */
  public List<Integer> getReversedListFromArray(int[] array) {
    List<Integer> list = new ArrayList<>(array.length);
    for (int i = array.length - 1; i >= 0; i--) {
      list.add(array[i]);
    }

    return list;
  }
}
