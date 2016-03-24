package algorithm.stack;

import java.util.*;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
  public static String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();
    Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));

    for (String dir : path.split("/")) {
      // When meet ".." we need to do stack pop to get back to upper directory if stack is not empty
      if (dir.equals("..") && !stack.isEmpty()) {
        stack.pop();
      } else if (!skip.contains(dir)) {
        stack.push(dir);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/" + stack.pollLast());
    }

    return sb.length() == 0 ? "/" : sb.toString();
  }
}
