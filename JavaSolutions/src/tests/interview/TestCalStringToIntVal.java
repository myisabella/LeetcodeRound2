package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalStringToIntVal {
  CalStringToIntVal cal = new CalStringToIntVal();

  @Test
  public void testPartialMatch() {
    Assert.assertNotEquals(cal.getIntegerFromString("blu"), 1);
    Assert.assertNotEquals(cal.getIntegerFromString("ange"), 1);
  }

  @Test
  public void testUpperCase() {
    Assert.assertNotEquals(cal.getIntegerFromString("Blue"), 1);
    Assert.assertNotEquals(cal.getIntegerFromString("BLUE"), 1);
  }

  @Test
  public void testMatch() {
    Assert.assertEquals(cal.getIntegerFromString("blue"), 1);
    Assert.assertEquals(cal.getIntegerFromString("aaaaaaaaaa"), 2);
    Assert.assertEquals(cal.getIntegerFromString(""), 3);
  }
}
