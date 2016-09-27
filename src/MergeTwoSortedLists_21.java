// O(n)
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode iter = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            }
            else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        if (l1 != null)
            iter.next = l1;
        if (l2 != null)
            iter.next = l2;
        return head.next;
    }
}
