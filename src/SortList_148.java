public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode endOfFirstHalf = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            endOfFirstHalf = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        endOfFirstHalf.next = null;

        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        return sortListHelper(node1, node2);
    }

    public ListNode sortListHelper(ListNode node1, ListNode node2) {
        ListNode newHead = new ListNode(0);
        ListNode iter = newHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                iter.next = node1;
                node1 = node1.next;
            } else {
                iter.next = node2;
                node2 = node2.next;
            }
            iter = iter.next;
        }
        if (node1 != null)
            iter.next = node1;
        if (node2 != null)
            iter.next = node2;
        return newHead.next;
    }
}
