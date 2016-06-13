package interview;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestWeightedRandom {
  private WeightedRandom wd;
  Map<String, Integer> map;

  @BeforeTest
  public void setup() {
    map = new HashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);

    wd = new WeightedRandom(map);
  }

  @Test
  public void test() {
    for (int i = 0; i < 6; i++) {
      System.out.println(wd.next());
    }
  }
}
