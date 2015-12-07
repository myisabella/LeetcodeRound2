package algorithm.bitmanipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the
 * Hamming weight).For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 *
 * Completed: 12/03/15
 */
public class NumberOfOneBits {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 1; i < 33; i++) {
      if (getBits(n, i)) {
        count++;
      }
    }

    return count;
  }

  private boolean getBits(int n, int i) {
    return (n & (1 << i)) != 0;
  }
}
