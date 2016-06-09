package algorithm.twopointers;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the
 * new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Follow up: What if duplicates are allowed at most twice?
 *
 * Time complexity: O(N), N is the length of array
 * Space complexity: O(1)
 *
 * Completed: 05/05/2015
 */
public class RemoveDuplicatesFromSortedArray {
  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length < 2) {
      return nums.length;
    }

    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[index] != nums[i]) {
        nums[++index] = nums[i];
      }
    }

    return index + 1;
  }

  public static int removeDuplicatesTwice(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int index = 0;
    for (int num : nums) {
      if (index < 2 || num > nums[index - 2]) {
        nums[index++] = num;
      }
    }

    return index;
  }

  // this solution is using the same idea as before but can avoid out of range warning
  public static int removeDuplicatesTwiceII(int[] nums) {
    if (nums == null) {
      return 0;
    }

    if (nums.length <= 2) {
      return nums.length;
    }

    int index = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[index - 2] < nums[i]) {
        nums[index++] = nums[i];
      }
    }

    return index;
  }
}
