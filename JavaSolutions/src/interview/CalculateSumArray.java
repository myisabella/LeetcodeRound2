package interview;

import java.util.Arrays;

/**
 * Provide a function that calculates the sum of an array of integers
 */
public class CalculateSumArray {
  public int getSumAsInt(int[] array) {
    return Arrays.stream(array).sum();
  }

  public long getSumAsLong(int[] array) {
    return Arrays.stream(array).asLongStream().sum();
  }
}
