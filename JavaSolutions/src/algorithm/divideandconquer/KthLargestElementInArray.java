package algorithm.divideandconquer;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted
 * order, not the kth distinct element.
 *
 * For example,
 * Given [3, 2, 1, 5, 6, 4] and k = 2, return 5.
 *
 * You may assume k is always valid, 1 <= k <= array's length.
 */
public class KthLargestElementInArray {
  /**
   * Find kth largest using a min orientated priority queue.
   * The algorithm will iterate over the array and maintain the size of priority queue.
   * Time complexity: O(Nlogk), Space complexity: O(k)
   * @param nums    input unsorted array
   * @param k       index that should in between 1 and array's length
   * @return        kth largest element in the input array
   */
  public static int findKthLargestWithPQ(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int elem : nums) {
      pq.offer(elem);

      if (pq.size() > k) {
        pq.poll();
      }
    }

    return pq.peek();
  }

  /**
   * Find the kth largest element using selection algorithm.
   * Time complexity: O(N), Space complexity: O(1)
   * @param nums
   * @param k
   * @return
   */
  public static int findKthLargestWithSelection(int[] nums, int k) {
    // Shuffle the input array so that our time complexity should be O(N)
    shuffle(nums);

    // selection algorithm will find the kth smallest element so we need to update k
    k = nums.length - k;
    int lo = 0, hi = nums.length - 1;

    while (lo < hi) {
      final int j = partition(nums, lo, hi);
      if (j < k) {
        lo = j + 1;
      } else if (j > k) {
        hi = j - 1;
      } else {
        break;
      }
    }

    return nums[k];
  }

  /**
   * Shuffle input array to randomize
   * @param a   input array
   */
  private static void shuffle(int[] a) {
    final Random random = new Random();
    for (int i = 1; i < a.length; i++) {
      final int r = random.nextInt(i + 1);
      exch(a, i, r);
    }
  }

  /**
   * Partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi] and return the index j
   * @param a     input subarray
   * @param lo    lowe index of subarray
   * @param hi    high index of subarray
   * @return      partition index
   */
  private static int partition(int[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    int v = a[lo];

    while (true) {
      // find item on lo to swap
      while (a[++i] < v) {
        if (i == hi) {
          break;
        }
      }

      // find item on hi to swap
      while (v < a[--j]) {
        if (j == lo) {
          break;
        }
      }

      // check if pointers cross
      if (i >= j) {
        break;
      }

      exch(a, i, j);
    }

    // put partitioning item v at a[j]
    exch(a, lo, j);

    return j;
  }

  private static void exch(int[] a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}
