package algorithm.twopointers;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Time complexity: O(mn), m is the length of haystack, n is the length of needle
 * Space complexity: O(1)
 *
 * Completed: 05/04/2016
 */
public class ImplementstrStr {
  public static int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) {
          return i;
        }

        if (i + j == haystack.length()) {
          return -1;
        }

        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
    }
  }
}
