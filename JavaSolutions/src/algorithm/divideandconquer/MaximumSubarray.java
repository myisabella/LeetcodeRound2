package algorithm.divideandconquer;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 * Completed: 04/06/2016
 */
public class MaximumSubarray {
  // Time complexity: O(N)
  public static int maxSubArrayGreedy(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;
  }

  public static int maxSubArrayDAC(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    return maxSubArrayDACHelper(nums, 0, nums.length - 1);
  }

  /**
   * Step 1: select the middle element of the array, so the maximum subarray might contain the middle element or not
   * Step 2.1: if the maximum subarray does not contain the middle element, then we apply it to the subarray to the left
   *           of the middle element and the one to the right of the middle element
   * Step 2.2: if the maximum subarray contains the middle element, then the result will be the maximum suffix
   *           subarray fo the left subarray plus the maximum prefix subarray of the right subarray
   * Step 3: return the maximum of those three answers
   */
  private static int maxSubArrayDACHelper(int[] nums, int left, int right) {
    if (left == right) {
      return nums[left];
    }

    int middle = (left + right) / 2;
    int leftRes = maxSubArrayDACHelper(nums, left, middle);
    int rightRes = maxSubArrayDACHelper(nums, middle + 1, right);

    int leftMax = nums[middle];
    int rightMax = nums[middle + 1];
    int temp = 0;

    for (int i = middle; i >= left; i--) {
      temp += nums[i];
      if (temp > leftMax) {
        leftMax = temp;
      }
    }

    temp = 0;
    for (int i = middle + 1; i <= right; i++) {
      temp += nums[i];
      if (temp > rightMax) {
        rightMax = temp;
      }
    }

    return Math.max(Math.max(leftRes, rightRes), leftMax + rightMax);
  }

}
