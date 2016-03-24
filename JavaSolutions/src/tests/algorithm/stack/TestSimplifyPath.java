package algorithm.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSimplifyPath {
  private String[] paths = {
      "/home/",
      "/a/./b/../../c/",
      "/../",
      "home//foo/"
  };

  private String[] answers = {
      "/home",
      "/c",
      "/",
      "/home/foo"
  };

  @Test
  public void testSimpleCases() {
    for (int i = 0; i < paths.length; i++) {
      Assert.assertEquals(SimplifyPath.simplifyPath(paths[i]), answers[i]);
    }
  }
}
