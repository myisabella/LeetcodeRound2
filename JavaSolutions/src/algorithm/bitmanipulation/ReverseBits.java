package algorithm.bitmanipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 
 * (represented in binary as 00111001011110000010100101000000).
 *
 * Completed: 12/03/15
 */
public class ReverseBits {
  public int reverseBits(int n) {
    for (int i = 0; i < 16; i++) {
      n = swapBits(n, i, 32 - i - 1);
    }

    return n;
  }

  private int swapBits(int n, int i, int j) {
    int lo = (n << i) & 1;
    int hi = (n << j) & 1;

    if ((lo ^ hi) != 0) {
      return n ^= (1 << i) | (1 << j);
    }

    return n;
  }
}
