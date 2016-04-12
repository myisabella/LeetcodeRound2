package algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here *follow* means a full match, such that there is a bijection between a letter in pattern and a
 * non-empty word in str.
 *
 * You may assume pattern contains only lowercase letters, and str contains lower letters separated by
 * a single space.
 *
 * Completed: 04/11/2016
 */
public class WordPattern {
  public static boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }

    Map index = new HashMap<>();
    for (Integer i = 0; i < words.length; i++) {
      if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
        return false;
      }
    }
    return true;
  }
}
