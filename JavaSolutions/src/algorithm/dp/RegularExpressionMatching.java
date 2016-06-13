package algorithm.dp;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' matches any single character.
 * '*' matches zero or more of the preceding element.
 */
public class RegularExpressionMatching {
  public static boolean isMatchRecursive(String s, String p) {
    if (p.isEmpty()) {
      return s.isEmpty();
    }

    if (p.length() == 1) {
      if (s.isEmpty()) {
        return false;
      } else if (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)) {
        return false;
      } else {
        return isMatchRecursive(s.substring(1), p.substring(1));
      }
    }

    // case 1: when the 2nd char of p is '*'
    if (p.charAt(1) == '*') {
      // case 1.1: '*' stands for 0 element
      if (isMatchRecursive(s, p.substring(2))) {
        return true;
      }

      // case 1.2: '*' stands for 1 or more preceding element
      int i = 0;
      while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
        if (isMatchRecursive(s.substring(i + 1), p.substring(2))) {
          return true;
        }
        i++;
      }
      return false;
    }
    // case 2: when the 2nd char of p is not '*'
    else {
      if (s.length() < 1) {
        return false;
      }
      if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
        return false;
      } else {
        return isMatchRecursive(s.substring(1), p.substring(1));
      }
    }
  }

  public static boolean isMatchDP(String s, String p) {
    /**
     * f[i][j] is true if s[0..i-1] matches p[0..j-1]
     * if p[j-1] is not '*':
     *    f[i][j] = f[i-1][j-1] && s[i-1] == p[j-1]
     * if p[j-1] is '*':
     *    let v = p[j-2]
     *    f[i][j] is true iff any of the following is true:
     *        1) 'v*' repeats 0 time and matches empty: f[i][j-2]
     *        2) 'v*' repeats 1 or more times and matches 'v*v': s[i-1] == v && f[i-1][j]
     * '.' matches any single character
     */

    int m = s.length(), n = p.length();
    boolean[][] func = new boolean[m + 1][n + 1];

    // special case: two empty strings are matched
    func[0][0] = true;

    for (int i = 1; i <= m; i++) func[i][0] = false;

    for (int j = 1; j <= n; j++) {
      func[0][j] = j > 1 && '*' == p.charAt(j - 1) && func[0][j - 2];
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (p.charAt(j - 1) != '*') {
          func[i][j] = func[i - 1][j - 1]
                    && (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1));
        } else {
          func[i][j] = func[i][j - 2]
                    || (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2))
                    && func[i - 1][j];
        }
      }
    }
    return func[m][n];
  }
}
