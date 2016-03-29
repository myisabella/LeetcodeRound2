package interview;

/**
 * Given an array with each element is positive integer, try to add the operators, "+", "*", "(", ")" to maximize
 * the result. The position in the array is fixed.
 *
 * For example, given an array [2, 1, 1, 2], you can get (2 + 1) * (2 + 1) = 9
 */
public class MaximizeArray {
  public static int findMaxOperation(int[] numbers) {
    int length = numbers.length;
    int[][] D = new int[length][length];

    for (int i = 0; i < length; i++) {
      D[i][i] = numbers[i];
      for (int j = i - 1; j > -1; j--) {
        int diff = i - j;
        int tempMax = 0;
        for (int k = 0; k < diff; k++) {
          tempMax = Math.max(tempMax, Math.max(D[i][i-k] + D[i-k-1][j], D[i][i-k] * D[i-k-1][j]));
        }
        D[i][j] = tempMax;
      }
    }

    return D[length-1][0];
  }
}
