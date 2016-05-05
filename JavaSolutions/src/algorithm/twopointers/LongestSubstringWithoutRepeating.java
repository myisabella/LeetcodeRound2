package algorithm.twopointers;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Time complexity: O(N), N is the length of input string
 * Space complexity: O(m), m is the size of charset
 *
 * Completed: 05/05/2016
 */
public class LongestSubstringWithoutRepeating {
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int len = 0;
    int[] map = new int[256];

    for (int i = 0, j = 0; j < s.length(); j++) {
      i = Math.max(map[s.charAt(j)], i);
      len = Math.max(j - i + 1, len);
      map[s.charAt(j)] = j + 1;
    }

    return len;
  }
}
