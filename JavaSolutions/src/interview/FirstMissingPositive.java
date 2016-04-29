package interview;

/**
 * Created by xawei on 4/22/16.
 */
public class FirstMissingPositive {
  public static int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] > 0
          && nums[i] <= nums.length
          && nums[i] != i + 1
          && nums[i] != nums[nums[i] - 1]) {
        int temp = nums[nums[i] - 1];
        nums[nums[i]-1] = nums[i];
        nums[i] = temp;
      }
    }

    int index = 0;
    while (index < nums.length && nums[index] == index + 1) {
      ++index;
    }
    return index + 1;
  }
}
