public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode iter = head;
        while (iter.next != null) {
            if (iter.next == head)
                return true;
            ListNode temp = iter.next;
            iter.next = head;
            iter = temp;
        }
        return false;
    }
}
