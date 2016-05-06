package algorithm.twopointers;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T
 * in complexity O(n).
 *
 * Time complexity: O(n), n is the length of s
 * Space complexity: O(m), m is the number of unique chars in s and t
 *
 * Completed: 05/05/2016
 */
public class MinimumWindowSubstring {
  public static String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    String res = "";

    HashMap<Character, Integer> target = new HashMap<>();
    for (char c : t.toCharArray()) {
      if (target.containsKey(c)) {
        target.put(c, target.get(c) + 1);
      } else {
        target.put(c, 1);
      }
    }

    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0, count = 0, minLen = s.length() + 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (target.containsKey(c)) {
        if (map.containsKey(c)) {
          if (map.get(c) < target.get(c)) {
            count++;
          }
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
          count++;
        }
      }

      if (count == t.length()) {
        char sc = s.charAt(left);
        while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
          if (map.containsKey(sc) && map.get(sc) > target.get(sc)) {
            map.put(sc, map.get(sc) - 1);
          }
          left++;
          sc = s.charAt(left);
        }

        if (i - left + 1 < minLen) {
          res = s.substring(left, i + 1);
          minLen = i - left + 1;
        }
      }
    }

    return res;
  }
}
