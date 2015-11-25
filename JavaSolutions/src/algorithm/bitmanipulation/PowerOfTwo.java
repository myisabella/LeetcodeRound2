package algorithm.bitmanipulation;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Completed: 11/24/15
 */
public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    } else {
      return (n & (n - 1)) == 0;
    }
  }
}
