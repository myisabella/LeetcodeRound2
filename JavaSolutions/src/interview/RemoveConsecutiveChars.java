package interview;

/**
 * Remove the consecutive chars in string, e.g. "abbc" -> "ac", "aa" -> "",
 * "acccbdd" -> "ab", "" -> "", "abbabb" -> ""
 */
public class RemoveConsecutiveChars {
  public static String removeConsecutiveChars(String str) {
    if (str == null || str.length() == 0) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    while (j < str.length()) {
      while (j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) {
        j++;
      }
      if (i == j) {
        sb.append(str.charAt(i));
      }
      j++;
      i = j;
    }

    // no consecutive chars in input string
    if (sb.toString().equals(str)) {
      return sb.toString();
    }

    // recursive call to remove all consecutive chars
    return removeConsecutiveChars(sb.toString());
  }
}
