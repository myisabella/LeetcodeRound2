package algorithm.linkedlist;

/**
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {
  public static boolean isPalindrome(ListNode head) {
    // find the middle element of linked list
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // for odd number of elements, we need to move slow to the next one
    if (fast != null) {
      slow = slow.next;
    }

    slow = reverseList(slow);
    while (slow != null && head.val == slow.val) {
      head = head.next;
      slow = slow.next;
    }

    return slow == null;
  }

  private static ListNode reverseList(ListNode head) {
    ListNode newHead = null;

    while (head != null) {
      ListNode nextNode = head.next;
      head.next = newHead;
      newHead = head;
      head = nextNode;
    }

    return newHead;
  }
}
