package algorithm.linkedlist;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReverseLinkedList {
  public static ListNode oneElement = new ListNode(1);
  public static ListNode node = new ListNode(1);

  @BeforeTest
  public void setup() {
    int[] array = {2, 3, 4, 5};
    ListNode tmp = node;
    for (int i : array) {
      tmp.next = new ListNode(i);
      tmp = tmp.next;
    }
  }

  @Test
  public void testNullCase() {
    Assert.assertTrue(ReverseLinkedList.reverseListIteratively(null) == null);
    Assert.assertTrue(ReverseLinkedList.reverseListRecursively(null) == null);
  }

  @Test
  public void testOneElement() {
    Assert.assertEquals(oneElement, ReverseLinkedList.reverseListIteratively(oneElement));
    Assert.assertEquals(oneElement, ReverseLinkedList.reverseListRecursively(oneElement));
  }

  @Test
  public void testNormalCase() {
    Assert.assertEquals(node, ReverseLinkedList.reverseListIteratively(ReverseLinkedList.reverseListIteratively(node)));
    Assert.assertEquals(node, ReverseLinkedList.reverseListRecursively(ReverseLinkedList.reverseListRecursively(node)));
  }
}
