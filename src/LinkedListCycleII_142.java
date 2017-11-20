public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
