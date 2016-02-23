package algorithm.linkedlist;

/**
 * Reverse a singly linked list.
 * A linked list can be reversed either iteratively or recursively.
 *
 * Completed: 02/22/2016
 */
public class ReverseLinkedList {
  /**
   * Iteratively reverse a linked list
   * Time: O(N), Space: O(1)
   * @param head
   * @return
   */
  public static ListNode reverseListIteratively(ListNode head) {
    ListNode newHead = null;

    while (head != null) {
      ListNode nextNode = head.next;
      head.next = newHead;
      newHead = head;

      head = nextNode;
    }

    return newHead;
  }

  public static ListNode reverseListRecursively(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode nextNode = head.next;
    ListNode newHead = reverseListRecursively(nextNode);

    nextNode.next = head;
    head.next = null;

    return newHead;
  }
}
