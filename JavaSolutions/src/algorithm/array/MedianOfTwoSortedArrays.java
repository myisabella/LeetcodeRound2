package algorithm.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Approach: search i in range [0, m] so that nums2[j-1] <= nums1[i] and nums1[i-1] <= nums2[j]
 * where j = (m+n+1)/2, use binary search to ensure time complexity.
 */
public class MedianOfTwoSortedArrays {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1 == null && nums2 == null) {
      return 0.0;
    }

    int len1 = nums1.length, len2 = nums2.length;
    return len1 < len2 ? helper(nums1, nums2) : helper(nums2, nums1);
  }

  private static double helper(int[] arr1, int[] arr2) {
    int m = arr1.length, n = arr2.length;
    int min = 0, max = m, halfLen = (m + n + 1) / 2;
    int maxLeft, minRight;

    while (min <= max) {
      int i = (min + max) / 2, j = halfLen - i;
      if (i < m && j > 0 && arr2[j - 1] > arr1[i]) {
        min = i + 1;
      } else if (i > 0 && j < n && arr1[i - 1] > arr2[j]) {
        max = i - 1;
      } else {
        if (i == 0) {
          maxLeft = arr2[j - 1];
        } else if (j == 0) {
          maxLeft = arr1[i - 1];
        } else {
          maxLeft = Math.max(arr1[i - 1], arr2[j - 1]);
        }

        // sum of lengths is odd
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        if (i == m) {
          minRight = arr2[j];
        } else if (j == n) {
          minRight = arr1[i];
        } else {
          minRight = Math.min(arr1[i], arr2[j]);
        }

        return (maxLeft + minRight) / 2.0;
      }
    }

    return 0.0;
  }
}
