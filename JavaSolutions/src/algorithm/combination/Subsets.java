package algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note:
 *   - Elements in a subset must be in non-descending order.
 *   - The solution set must not contain duplicate subsets.
 */
public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    if (nums == null || nums.length == 0) {
      return res;
    }

    List<Integer> temp = new ArrayList<>();
    res.add(temp);

    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      int len = res.size();
      for (int j = 0; j < len; j++) {
        temp = new ArrayList<>(res.get(j));
        temp.add(nums[i]);
        res.add(temp);
      }
    }

    return res;
  }
}
