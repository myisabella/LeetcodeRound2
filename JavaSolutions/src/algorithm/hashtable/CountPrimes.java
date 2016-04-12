package algorithm.hashtable;

/**
 * Count the number of prime numbers less than non-negative number, n.
 *
 * Completed: 04/11/2016
 */
public class CountPrimes {
  /**
   * Time complexity: O(N * log(log(n))), Space complexity: O(n)
   * @param n
   * @return
   */
  public int countPrimesSieve(int n) {
    if (n < 1) {
      return 0;
    }

    boolean[] isPrime = new boolean[n];
    for (int i = 2; i < n; i++) {
      isPrime[i] = true;
    }

    // Loop's ending condition is i * i < n instead of i < sqrt(n)
    // to avoid repeatedly calling an expensive function sqrt(n)
    for (int i = 2; i * i < n; i++) {
      if (!isPrime[i]) continue;
      for (int j = i * i; j < n; j += i) {
        isPrime[j] = false;
      }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i]) count++;
    }
    return count;
  }

  public int countPrimesSimple(int n) {
    boolean[] notPrime = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (!notPrime[i]) {
        count++;
        for (int j = 2; i * j < n; j++) {
          notPrime[i * j] = true;
        }
      }
    }
    return count;
  }
}
