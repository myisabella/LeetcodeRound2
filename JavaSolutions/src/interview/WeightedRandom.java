package interview;

import java.util.Map;
import java.util.Random;

/**
 * Given a map like this:
 * {"A": 1, "B": 2, "C": 3} which each integer represents the possibility each string shows
 * Write a class to provide a next() method which returns a string from the keys with correct possibility
 * e.g. when calling next() 6 times, "A" should appear ~1 time, "B": ~2 times, "C": ~3 times
 */
public class WeightedRandom {
  private int totalWeights = 0;
  private Map<String, Integer> map;

  public WeightedRandom(final Map<String, Integer> init) {
    map = init;
    for (String key : map.keySet()) {
      totalWeights += map.get(key);
    }
  }

  public String next() {
    Random random = new Random();
    int n = random.nextInt(totalWeights);
    for (String key : map.keySet()) {
      int weight = map.get(key);
      if (n < weight) {
        return key;
      }
      n = n - weight;
    }
    return "";
  }
}
