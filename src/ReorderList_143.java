public class ReorderList_143 {
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode itr = head;
        while (itr != null)   {
            length++;
            itr = itr.next;
        }
        if (length > 2) {
            length = (length + 1) / 2;

            ListNode iter = head;
            while (length-- > 1) {
                iter = iter.next;
            }

            ListNode subHead = reverse(iter.next);
            iter.next = null;
            merge(head, subHead);
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null)   return head;
        ListNode newHead = new ListNode(0);
        ListNode iter = head;
        while (iter.next != null) {
            ListNode next = iter.next;
            iter.next = newHead.next;
            newHead.next = iter;
            iter = next;
        }
        iter.next = newHead.next;
        newHead.next = iter;
        return newHead.next;
    }

    public void merge(ListNode head, ListNode subHead) {
        ListNode subIter = subHead;
        ListNode iter = head;
        while (subIter != null) {
            ListNode next = iter.next;
            iter.next = subIter;
            subIter = subIter.next;
            iter.next.next = next;
            iter = next;
        }
    }
}
