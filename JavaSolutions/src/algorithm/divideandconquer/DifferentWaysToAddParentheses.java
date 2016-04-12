package algorithm.divideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways
 * to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 * Input: "2-1-1".
 *    ((2-1)-1) = 0
 *    (2-(1-1)) = 2
 * Output: [0, 2]
 */
public class DifferentWaysToAddParentheses {
  public List<Integer> diffWaysToCompute(String input) {
    HashMap<String, List<Integer>> cache = new HashMap<>();
    return diffWaysToComputeHelper(input, cache);
  }

  private List<Integer> diffWaysToComputeHelper(String s, HashMap<String, List<Integer>> cache) {
    // if this compute way is already done, then return to the cached list
    if (cache.get(s) != null) {
      return cache.get(s);
    }

    boolean isExpression = false;
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if ("+-*".indexOf(s.charAt(i)) != -1) {
        List<Integer> leftRes = diffWaysToComputeHelper(s.substring(0, i), cache);
        List<Integer> rightRes = diffWaysToComputeHelper(s.substring(i + 1), cache);

        for (int leftVal : leftRes) {
          for (int rightVal : rightRes) {
            res.add(cal(leftVal, rightVal, s.charAt(i)));
          }
        }
        isExpression = true;
      }
    }

    if (!isExpression) {
      res.add(Integer.parseInt(s));
    }

    cache.put(s, res);
    return res;
  }

  private int cal(int leftVal, int rightVal, char operator) {
    int res = 0;
    switch (operator) {
      case '+':
        res = leftVal + rightVal;
        break;
      case '-':
        res = leftVal - rightVal;
        break;
      case '*':
        res = leftVal * rightVal;
        break;
      default:
        break;
    }
    return res;
  }
}
