package algorithm.tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 *
 * Completed: 02/19/2016
 */

public class UniqueBST {
  public static int numTrees(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    int []G = new int[n + 1];

    // base case
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        G[i] += G[j - 1] * G[i - j];
      }
    }

    return G[n];
  }
}
